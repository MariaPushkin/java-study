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
    public void add() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
    }

    @Test
    public void addFirst() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(5);
        test.add(9);
        test.addFirst(8);
        Assert.assertEquals(8,(int)test.get(0));
    }

    @Test
    public void addWithIndex() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(5);
        test.add(9);
        Assert.assertEquals(5,(int)test.get(1));
        test.add(1,8);
        Assert.assertEquals(8,(int)test.get(1));
        Assert.assertEquals(5,(int)test.get(2));
    }

    @Test
    public void remove() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(5);
        test.add(9);
        Assert.assertEquals(9,(int)test.getLast());
        test.remove();
        Assert.assertEquals(5,(int)test.getLast());
        test.remove();
        test.remove();
        Assert.assertEquals(0,test.size());
    }

    @Test
    public void removeByIndex() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(5);
        test.add(9);
        Assert.assertEquals(5,(int)test.get(1));
        test.remove(1);
        Assert.assertEquals(9,(int)test.get(1));
    }

    @Test
    public void removeByElement() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(9);
        test.add(5);
        test.add(9);
        test.add(3);
        test.remove((Integer) 9);
        Assert.assertEquals(5,(int)test.get(1));
        Assert.assertEquals(3,(int)test.get(2));
    }

    @Test
    public void removeFirst() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(5);
        test.add(9);
        Assert.assertEquals(2,(int)test.getFirst());
        test.removeFirst();
        Assert.assertEquals(5,(int)test.getFirst());
        test.removeFirst();
        test.removeFirst();
        Assert.assertEquals(0,test.size());
    }

    @Test
    public void contains() throws Exception {
    }

    @Test
    public void size() throws Exception {
    }

    @Test
    public void clear() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(5);
        test.add(9);
        test.clear();
        Assert.assertEquals(0,test.size());
        System.out.println(test.size());
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

    @Test
    public void indexOf() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(3);
        test.add(5);
        Assert.assertEquals(1,test.indexOf(3));
    }

    @Test
    public void lastIndexOf() throws Exception {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        test.add(2);
        test.add(3);
        test.add(5);
        test.add(3);
        Assert.assertEquals(3,test.lastIndexOf(3));
    }
}