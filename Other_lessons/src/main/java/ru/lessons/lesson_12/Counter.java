package ru.lessons.lesson_12;

/**
 * Урок по потокам
 * Класс счетчик
 * Дата 27.11.17
 */
public class Counter {
    private int amount;

    public synchronized int increase() {
        amount++;
        return amount;
    }
}
