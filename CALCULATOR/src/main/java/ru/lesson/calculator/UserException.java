package ru.lesson.calculator;

/*
 Пользовательское исключение
 дата 15.11.17
* */
public class UserException extends Exception {
    public UserException(final String message) {
        super(message);
    }
}
