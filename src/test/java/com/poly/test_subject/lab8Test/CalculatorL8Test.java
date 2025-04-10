package com.poly.test_subject.lab8Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorL8Test {
    CaculatorL8 calc = new CaculatorL8();

    @Test
    public void testAdd() {
        Assert.assertEquals(calc.add(2, 3), 5);
    }

    @Test
    public void testAdd2() {
        Assert.assertEquals(calc.add(1, 3), 5);
    }

    @Test
    public void testDivideByZero() {
        try {
            calc.divide(4, 0);
            Assert.fail("Expected exception not thrown");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }
}