package ru.lessons.mylists;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    @Test
    public void getFirst() throws Exception {
    }

    @Test
    public void getLast() throws Exception {
    }

    @Test
    public void removeFirst() throws Exception {
    }

    @Test
    public void add() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
    }

    @Test
    public void addFirst() throws Exception {
    }

    @Test
    public void contains() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

    @Test
    public void get() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        Assert.assertEquals(2,(int)test.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getWithException() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.get(2);
    }

    @Test
    public void set() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(3);
        test.add(5);
        Assert.assertEquals(5,(int)test.get(2));
        Assert.assertEquals(5,(int)test.set(2,7));
        Assert.assertEquals(7,(int)test.get(2));
    }

}