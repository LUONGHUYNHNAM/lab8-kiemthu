package  com.poly.test_subject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.test_subject.Data;
import com.poly.test_subject.model.User;


@RestController
@RequestMapping("/auth")
public class LoginController {
    

    @GetMapping("/login")
    public String login(
                                                @RequestParam String username,
                                                @RequestParam String password ) 
                                                {
        List<User> users = Data.getAllUser();
        users.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst().orElse(null);
                System.out.println("Vao login");
        return "Login success";
    }
    

}