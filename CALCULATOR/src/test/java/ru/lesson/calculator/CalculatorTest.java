package ru.lesson.calculator;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void add() throws Exception {
        Calculator calculator = new Calculator();
        calculator.add(1,1);
        Assert.assertEquals(2, calculator.getResult());
    }

    @Test
    public void div() throws Exception {
        Calculator calculator = new Calculator();
        calculator.div(4,2);
        Assert.assertEquals(2, calculator.getResult());
    }

    @Test(expected = UserException.class)
    public void divUserException() throws Exception {
        Calculator calculator = new Calculator();
        calculator.div();
    }

    @Test(expected = ArithmeticException.class)
    public void divArithException() throws Exception {
        Calculator calculator = new Calculator();
        calculator.div(4,0);
    }

    @Test
    public void remove() throws Exception {
        Calculator calculator = new Calculator();
        calculator.remove(5,2);
        Assert.assertEquals(3, calculator.getResult());
    }

    @Test
    public void mult() throws Exception {
        Calculator calculator = new Calculator();
        calculator.mult(5,2);
        Assert.assertEquals(10, calculator.getResult());
    }


}