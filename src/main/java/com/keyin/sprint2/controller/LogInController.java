package com.keyin.sprint2.controller;

import com.keyin.sprint2.model.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/logInUser", method = RequestMethod.POST)
public class LogInController {

    public void loginUser(@ModelAttribute User user, BindingResult errors, Model model) {
        // logic to process input data
    }
}
