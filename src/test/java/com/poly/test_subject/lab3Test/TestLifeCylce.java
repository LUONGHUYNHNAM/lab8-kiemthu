package com.poly.test_subject.lab3Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class TestLifeCylce {
    
    @BeforeAll
    static void BeforeAll() {
        System.out.println("@BeforeAll - Constructor has been created !");
    }

    @BeforeEach
    void BeforeEach () {
        System.out.println(" @BeforEach - Prepare for testcase1");
    }

    @Test
    void testcase1 () {
        System.out.println("   @Test - Testing testcase 1");
    }

    @org.junit.jupiter.api.AfterEach
    void AfterEach() {
        System.out.println(" @AfterEach - Testcase1 is done !");
    }


    @Test
    @Disabled
    void testcase2() {
        System.out.println("testcase2 is disabled");
    }

    @AfterAll
    static void AfterAll () {
        System.out.println("@AfterAll - All test is done !");
    }


}
