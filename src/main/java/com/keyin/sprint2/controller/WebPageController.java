package com.keyin.sprint2.controller;

import com.keyin.sprint2.model.Webpage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebPageController {
    @Autowired
    private Webpage webpage;

    @GetMapping(path = "/message")
    @ResponseBody
    public String message() {

        return webpage.get();
    }
}
