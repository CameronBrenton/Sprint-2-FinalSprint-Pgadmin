package com.keyin.sprint2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
