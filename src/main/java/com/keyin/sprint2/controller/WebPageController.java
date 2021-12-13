package com.keyin.sprint2.controller;

import com.keyin.sprint2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Front-end webpage routes for the user
@Controller
public class WebPageController {

    @GetMapping(path = "/logIn")
    public String getLogInPage() {

        return "logIn.html";
    }

    @GetMapping(path = "/logout")
    public String getLogOutPage() {

        return "logout.html";
    }

    @GetMapping(path = "/search")
    public String getSearchPage() {

        return "search.html";
    }

    @GetMapping(path = "/signup")
    public String getSignupPage() {

        return "signup.html";
    }

    @GetMapping(path = "/results")
    public String getResultsPage() {

        return "results.html";
    }

    @GetMapping(path = "/error")
    public String getErrorPage() {

        return "error.html";
    }

    @RequestMapping(value = "/logInUser", method = RequestMethod.POST)
    public void loginUser(@ModelAttribute User user, BindingResult errors, Model model) {
        // logic to process input data
    }

    @RequestMapping(value = "/signupUser", method = RequestMethod.POST)
    public String signupUser(@ModelAttribute User user, BindingResult errors, Model model) {
        // logic to process input data

//        String email = user.getEmail();
//        String password = user.getPassword();
//        //ModelAndView modelAndView = new ModelAndView();
//        //modelAndView.setViewName("login.html");
//        model.addAttribute(,user);
          return "login";
    }
}
