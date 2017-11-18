package ru.lesson.calculator;

import java.util.*;

/**
 * Пратика ArrayList, LinkedList, HashSet, HashMap
 * Дата 18.11.17
 */
public class UserRunner {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<String, User>();
        users.put("1", new User("1","first"));
        users.put("2", new User("2","two"));
        users.put("1", new User("1","first"));

        for(Map.Entry <String, User> user : users.entrySet()) {
            System.out.println(user);
        }
    }
}
