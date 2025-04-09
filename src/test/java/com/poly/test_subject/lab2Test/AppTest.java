package com.poly.test_subject.lab2Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.poly.test_subject.lab2.App;

public class AppTest {
    App app = new App();

    @Test
    void testIsEvenNumber() {
        
        assertTrue(app.isEvenNumber(2));

    }

    @Test
    void testIsEvenNumber1() {
        assertFalse(app.isEvenNumber(3));
    }


}
