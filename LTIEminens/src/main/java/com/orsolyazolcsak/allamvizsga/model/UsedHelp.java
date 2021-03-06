package com.orsolyazolcsak.allamvizsga.model;


import javax.persistence.*;

@Entity
@Table(name = "used_help")
public class UsedHelp {
    @Id
    @Column(name = "used_help_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usedHelp_Sequence")
    @SequenceGenerator(name = "usedHelp_Sequence", sequenceName = "USEDHELP_SEQ")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "help_id", nullable = false)
    private Help help;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @ManyToOne(optional = false)
    private Exam exam;

    public UsedHelp() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Help getHelp() {
        return help;
    }

    public void setHelp(Help help) {
        this.help = help;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}