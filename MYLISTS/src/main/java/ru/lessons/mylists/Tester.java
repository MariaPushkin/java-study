package ru.lessons.mylists;

public class Tester {
    public static void main(String[] args) {
        try {
            MyArrayList<Integer> test = new MyArrayList<Integer>(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
        MyArrayList<Integer> test2 = new MyArrayList<Integer>(5);
        System.out.println("Here");

    }
}
