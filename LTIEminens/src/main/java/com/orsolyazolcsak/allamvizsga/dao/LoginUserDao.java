package com.orsolyazolcsak.allamvizsga.dao;

public class LoginUserDao {

    private String username;
    private char[] password;

    public LoginUserDao() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUserDao{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}


