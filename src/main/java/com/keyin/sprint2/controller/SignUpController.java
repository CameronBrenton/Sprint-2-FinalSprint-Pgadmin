package com.keyin.sprint2.controller;

import com.keyin.sprint2.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {
    @RequestMapping(value = "/signupUser", method = RequestMethod.POST)
    public String signupUser(@ModelAttribute User user, BindingResult errors, Model model) {
        // logic to process input data

        String email = user.getEmail();
        String password = user.getPassword();
        return email + password;
    }
}
