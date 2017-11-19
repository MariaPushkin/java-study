package ru.lessons.mylists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {
    @Before
    public void setUp() throws Exception {
        //MyArrayList<Integer> test = new MyArrayList<Integer>(5);
    }

    @Test
    public void getSize() throws Exception {
    }

    @Test
    public void isEmpty() throws Exception {
    }

    @Test
    public void contains() throws Exception {
        MyArrayList<String> test = new MyArrayList<String>(10);
        test.add("Alice");
        test.add("Doggy");
        Assert.assertTrue(test.contains("Alice"));
        Assert.assertFalse(test.contains("Potty"));
    }

    @Test
    public void indexOf() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>(10);
        test.add(5);
        test.add(2);
        test.add(3);
        test.add(3);
        Assert.assertEquals(0,test.indexOf(5));
        Assert.assertEquals(2,test.indexOf(3));
    }

    @Test
    public void lastIndexOf() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>(10);
        test.add(5);
        test.add(2);
        test.add(3);
        test.add(3);
        Assert.assertEquals(0,test.lastIndexOf(5));
        Assert.assertEquals(3,test.lastIndexOf(3));
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void set() throws Exception {
    }

    @Test
    public void add() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>(2);
        test.add(5);
        test.add(2);
        test.add(3);
        Assert.assertEquals(3,test.getSize());
        test.add(0,6);
        test.add(3,4);
        Assert.assertEquals(6,(int)test.get(0));
        Assert.assertEquals(4,(int)test.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithException1() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>(2);
        test.add(5,5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithException2() throws Exception {
        MyArrayList<Integer> test = new MyArrayList<Integer>(2);
        test.add(-4,5);
    }

    @Test
    public void toArray() throws Exception {
        MyArrayList<String> test = new MyArrayList<String>(3);
        test.add("5");
        test.add("3");
        test.add("2");
        Object[] newArray = test.toArray();
        Assert.assertEquals("5", newArray[0]);
        Assert.assertEquals("3", newArray[1]);
        Assert.assertEquals("2", newArray[2]);
    }

}