package ru.lesson.example.models;

public class User {
    private final int id;
    private final String login;
    private final String email;

    public User(final int id, final String login, final String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }
}
