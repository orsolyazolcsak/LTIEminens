package com.orsolyazolcsak.allamvizsga.model;

public class AuthenticationMessage {
    private String message;

    public AuthenticationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
