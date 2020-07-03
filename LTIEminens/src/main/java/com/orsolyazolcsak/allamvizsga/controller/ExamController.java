package com.orsolyazolcsak.allamvizsga.controller;

import com.orsolyazolcsak.allamvizsga.dao.AnswerDAO;
import com.orsolyazolcsak.allamvizsga.dao.ExamDAO;
import com.orsolyazolcsak.allamvizsga.dao.ProblemDAO;
import com.orsolyazolcsak.allamvizsga.model.*;
import com.orsolyazolcsak.allamvizsga.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.*;

@RestController
@RequestMapping("/exam")
public class ExamController {
    public static final Long DURATION_OF_QUESTION = 50L;
    private final ExamService examService;
    private final ProblemService problemService;
    private final AnswerService answerService;
    private final HelpService helpService;
    private final UserService userService;
    private Map<Exam, StartedExam> startedExams;


    @Autowired
    public ExamController(ExamService examService, ProblemService problemService, AnswerService answerService, HelpService helpService, UserService userService) {
        this.examService = examService;
        this.problemService = problemService;
        this.answerService = answerService;
        this.helpService = helpService;
        this.userService = userService;
        startedExams = new HashMap<>();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/start/{id}")
    public ResponseEntity<ExamDAO> startExam(@PathVariable Long id) {
        Optional<Exam> examOptional = examService.findById(id);
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            if (exam.getProblems().size() == 9 && !startedExams.containsKey(exam)) {
                ZonedDateTime startTime = ZonedDateTime.now();
                startedExams.put(exam, new StartedExam(exam, startTime));
                ExamDAO examDao = examService.toDao(exam);
                examDao.setStartTime(startTime);
                return new ResponseEntity<>(examDao, HttpStatus.OK);
            } else {
                System.out.println(exam.getProblems().size() < 9 ? "Exam doesn't have questions " : "" + (startedExams.containsKey(exam) ? "Exam is already started" : ""));
            }
        } else {
            System.out.println("Exam not found by examService, can't be started");
        }
        return new ResponseEntity<>(new ExamDAO(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/currentQuestion/{examId}")
    public ResponseEntity<ProblemDAO> getCurrentQuestionForExam(@PathVariable final Long examId) {

        Optional<Exam> examOptional = examService.findById(examId);
        if (!examOptional.isPresent()) {
            System.out.println("Exam not found for id " + examId);
            return getNoQuestionFoundResponse();
        }
        Exam exam = examOptional.get();
        StartedExam startedExam = startedExams.get(exam);
        System.out.println("startedExam = " + startedExam);
        Optional<Problem> currentQuestion = startedExam.getCurrentQuestion();
        System.out.println("looking for current question for examId = " + examId);

        if (currentQuestion.isPresent()) {
            Problem problem = currentQuestion.get();
            System.out.println("currentQuestion = " + problem);
            // TODO validate that user didn't already submit an answer
            return new ResponseEntity<>(problemService.toDao(problem), HttpStatus.OK);
        } else {
            System.out.println("No more time to submit question for exam " + examId);
            return getNoQuestionFoundResponse();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/currentQuestion/{examId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AnswerDAO> answerTheCurrentQuestionForExam(@PathVariable Long examId,
                                                                     @RequestBody AnswerDAO answerDAO) {
        ProblemDAO currentQuestionForExam = getCurrentQuestionForExam(examId).getBody();
        System.out.println("currentQuestionForExam = " + currentQuestionForExam);
        System.out.println("examId = " + examId + ", received answerDAO = " + answerDAO);
        if (currentQuestionForExam == null) {
            throw new IllegalStateException("Current question for exam is null, not empty dao");
        }
        if (currentQuestionForExam.equals(new ProblemDAO())) {
            System.out.println("could not find current question for exam, will reject answer " + answerDAO);
            return getInvalidAnswerResponse(answerDAO);
        }
        if (currentQuestionForExam.getId() == null
                || !currentQuestionForExam.getId().equals(answerDAO.getProblemId())) {
            System.out.println("Received answer but not for the current question for exam " + examId);
            System.out.println("Answer submitted was " + answerDAO);
            return getInvalidAnswerResponse(answerDAO);
        }
        if (answerService.existsByAnswerDao(answerDAO)) {
            System.out.println("User already answered this question");
            return getInvalidAnswerResponse(answerDAO);
        }
        Optional<Problem> problemOptional = problemService.findById(currentQuestionForExam.getId());
        if (!problemOptional.isPresent()) {
            throw new IllegalStateException("problemService couldn't find currentQuestion");
        }
        answerDAO.setCorrect(problemOptional.get().getCorrectAnswer().equals(answerDAO.getAnswer()));

        Answer savedAnswer = answerService.save(answerService.toAnswer(answerDAO));
        System.out.println("savedAnswer = " + savedAnswer);
        return new ResponseEntity<>(answerDAO, HttpStatus.OK);
    }

    @SuppressWarnings("MVCPathVariableInspection")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/currentQuestion/{examId}/fiftyFifty", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Set<String>> fiftyFifty(@RequestBody ProblemDAO problemDAO) {
        Optional<Problem> problem = problemService.findById(problemDAO.getId());
        //noinspection OptionalIsPresent
        if (!problem.isPresent()) {
            return new ResponseEntity<>(new HashSet<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(helpService.fiftyFifty(problem.get()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/currentQuestion/{examId}/askTheAudience", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, Long>> askTheAudience(@RequestBody ProblemDAO problemDAO, @PathVariable Long examId) {
        Optional<Problem> problem = problemService.findById(problemDAO.getId());

        Optional<Exam> exam = examService.findById(examId);
        if (!problem.isPresent() || !exam.isPresent()) {
            return new ResponseEntity<>(new HashMap<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(answerService.askTheAudience(exam.get(), problem.get()).getAudienceAnswers(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/currentQuestion/{examId}/phoneAFriendGetWatchers", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Set<String>> phoneAFriendGetWatchers(@RequestBody ProblemDAO problemDAO, @PathVariable Long examId) {
        Optional<Problem> problem = problemService.findById(problemDAO.getId());
        Optional<Exam> exam = examService.findById(examId);
        if (!problem.isPresent() || !exam.isPresent()) {
            return new ResponseEntity<>(new HashSet<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(answerService.findWatchersWhoAnswered(exam.get(), problem.get()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/currentQuestion/{examId}/phoneAFriend/{username}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> phoneAFriendGetAnswer(@RequestBody ProblemDAO problemDAO, @PathVariable Long examId, @PathVariable String username) {
        Optional<Problem> problem = problemService.findById(problemDAO.getId());
        Optional<Exam> exam = examService.findById(examId);
        Optional<User> byUsername = userService.findByUsername(username);
        if (!problem.isPresent() || !exam.isPresent() || !byUsername.isPresent()) {
            return new ResponseEntity<>("\"User didn't answer\"", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("\"" + answerService.phoneAFriend(exam.get(), problem.get(),
                byUsername.get()).orElse("User didn't answer") + "\"", HttpStatus.OK);
    }

    private ResponseEntity<AnswerDAO> getInvalidAnswerResponse(AnswerDAO answerDAO) {
        answerDAO.setCorrect(false);
        return new ResponseEntity<>(answerDAO, HttpStatus.NOT_ACCEPTABLE);
    }


    private ResponseEntity<ProblemDAO> getNoQuestionFoundResponse() {
        return new ResponseEntity<>(new ProblemDAO(), HttpStatus.NOT_ACCEPTABLE);
    }
}
