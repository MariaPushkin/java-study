package ru.lessons.lesson_11;

import java.util.*;

/**
 * Пратика ArrayList, LinkedList, HashSet, HashMap
 * Дата 18.11.17
 */
public class UserRunner {
    public static void main(String[] args) {
        Map<User, String> users = new HashMap<User, String>();
        User usr1 = new User("1","first");
        User usr2 = new User("2","two");
        User usr3 = new User("1","first");
        users.put(usr1,"1");
        users.put(usr2,"2");
        users.put(usr3,"3");

        System.out.println(users.get(usr1));

        for(Map.Entry <User, String> user : users.entrySet()) {
            System.out.println(user);
        }
    }
}
