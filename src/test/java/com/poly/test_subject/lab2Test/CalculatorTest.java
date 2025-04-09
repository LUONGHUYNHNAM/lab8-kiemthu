package com.poly.test_subject.lab2Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.poly.test_subject.lab2.Calculator;

public class CalculatorTest {
    
    Calculator cal =new Calculator();

    @Test
    void addTest() {
        assertEquals(10, cal.add(5, 5));
    }

    @Test
    void addTest2() {
        assertNotEquals(10, cal.add(5, 4));
    }

    @Test
    void substractTest() {
        assertEquals(5, cal.substract(10, 5));
    }

    @Test
    void substractTest2() {
        assertNotEquals(5, cal.substract(10, 4));
    }

    @Test
    void divideTest() {
        assertNull(0);
    }
}
