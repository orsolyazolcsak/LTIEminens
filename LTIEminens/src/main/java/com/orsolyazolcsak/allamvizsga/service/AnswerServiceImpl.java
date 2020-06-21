package com.orsolyazolcsak.allamvizsga.service;

import com.orsolyazolcsak.allamvizsga.dao.AnswerDAO;
import com.orsolyazolcsak.allamvizsga.model.Answer;
import com.orsolyazolcsak.allamvizsga.model.Exam;
import com.orsolyazolcsak.allamvizsga.model.Problem;
import com.orsolyazolcsak.allamvizsga.model.User;
import com.orsolyazolcsak.allamvizsga.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;
    private UserService userService;
    private ExamService examService;
    private ProblemService problemService;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, UserService userService, ExamService examService,
                             ProblemService problemService) {
        this.answerRepository = answerRepository;
        this.userService = userService;
        this.examService = examService;
        this.problemService = problemService;
    }

    @Override
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer toAnswer(AnswerDAO answerDAO) {
        Answer answer = new Answer();
        answer.setAnswerIsCorrect(answerDAO.getCorrect());
        answer.setUser(userService.findByUsername(answerDAO.getUser()).orElse(null));
        answer.setExam(examService.findById(answerDAO.getExamId())
                .orElseThrow(() -> new RuntimeException("Couldn't find exam of answerDao")));
        answer.setProblem(problemService.findById(answerDAO.getProblemId())
                .orElseThrow(() -> new RuntimeException("Couldn't find problem of answerDao")));
        return answer;
    }

    @Override
    public boolean existsByExamAndUserAndProblem(Exam exam, User user, Problem problem) {
        return answerRepository.existsByExamAndUserAndProblem(exam, user, problem);
    }

    @Override
    public boolean existsByAnswerDao(AnswerDAO answerDAO) {
        Optional<Exam> exam = examService.findById(answerDAO.getExamId());
        Optional<User> user = userService.findByUsername(answerDAO.getUser());
        Optional<Problem> problem = problemService.findById(answerDAO.getProblemId());
        return exam.isPresent() && user.isPresent() && problem.isPresent()
                && existsByExamAndUserAndProblem(exam.get(), user.get(), problem.get());
    }
}
