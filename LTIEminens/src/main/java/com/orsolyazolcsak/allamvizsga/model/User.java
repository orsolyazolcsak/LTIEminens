package com.orsolyazolcsak.allamvizsga.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

import static com.orsolyazolcsak.allamvizsga.service.UserServiceImpl.generateSalt;
import static com.orsolyazolcsak.allamvizsga.service.UserServiceImpl.hashPassword;

@Entity
@Table(name = "user_eminens")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Sequence")
    @SequenceGenerator(name = "user_Sequence", sequenceName = "USER_SEQ")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt", length = 4000)
    private String salt;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<Answer> answer;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private List<UsedHelp> usedHelp;

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        Optional<String> salt = generateSalt(512);

        if (salt.isPresent()) {

            Optional<String> securedPassword = hashPassword(password, salt.get());

            if (securedPassword.isPresent()) {
                this.salt = salt.get();
                this.password = securedPassword.get();
            } else {
                System.out.println("Error in setPassword: hashPassword");
            }
        } else {
            System.out.println("Error in setPassword: generateSalt");
        }

    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public List<UsedHelp> getUsedHelp() {
        return usedHelp;
    }

    public void setUsedHelp(List<UsedHelp> usedHelp) {
        this.usedHelp = usedHelp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}