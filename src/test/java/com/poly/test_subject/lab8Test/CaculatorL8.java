package com.poly.test_subject.lab8Test;

public class CaculatorL8 {


    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Divide by zero!");
        return a / b;
    }

    
}