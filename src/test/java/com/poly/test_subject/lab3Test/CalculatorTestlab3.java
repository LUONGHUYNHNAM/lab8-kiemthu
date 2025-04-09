package com.poly.test_subject.lab3Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.poly.test_subject.lab3.Calculator;

public class CalculatorTestlab3 {
    Calculator cal = new Calculator();
    
    public int sum (Integer a , Integer b ) {
        return cal.add(a, b);
    } 


    @Test
    void testCal () {
        assertThrows(ArithmeticException.class, () -> {
            int result = cal.divide(10, 0);
        }, "Lỗi đã được ném ra như mong muốn");
    }

    @Test
    void testNull() {
        assertThrows(NullPointerException.class, () -> {
            int result = sum(10, null);
        },"Lôi được ném ra ngoài");
    }

    @Test
    void TestStringNullPointer () {
        assertThrows(NullPointerException.class,() -> {
            String s = null;
            s.length();
        },"Pass");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,-2,-1,1,2,3})
    void testPrime(int a) {
        assertTrue(a > 0 , a + "la so chan");
    }

}
