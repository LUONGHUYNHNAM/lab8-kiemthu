package com.poly.test_subject;

import java.util.Arrays;
import java.util.List;

import com.poly.test_subject.model.User;

public class Data {
    
    public static List<User> getAllUser () {
        List<User> list = Arrays.asList(new User("nam","passwod"),
                new User("nam1","passwod1"),
                new User("nam2","passwod2"),
                new User("nam3","passwod3"));

        return list;
    }

}
