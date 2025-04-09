package com.poly.test_subject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.poly.test_subject.controller.LoginController;

public class LoginControllerTest {
    
    @Test
    void loginSuccess() {
        LoginController loginController = new LoginController();
        String result = loginController.login("nam", "password");
        assertEquals("Login success", result);
    }

}
