package com.keyin.sprint2.controller;

import com.keyin.sprint2.model.Animal;
import com.keyin.sprint2.model.Search;
import com.keyin.sprint2.model.User;
import com.keyin.sprint2.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Front-end webpage routes for the user
@Controller
public class MainController {
    @Autowired
    private AnimalRepo animalRepository;

    // Get Mappings
    @GetMapping(path = "/signin")
    public String getLogInPage() {

        return "signout";
    }

    @GetMapping(path = "/signout")
    public String getLogOutPage() {

        return "signout";
    }

    // Search PgAdmin
    @GetMapping(path = "/searchPgadmin")
    public String showSearchForm(Model model) {
        Search search = new Search();
        model.addAttribute("search", search);
        //List<String> databaseList = Arrays.asList("PgAdmin(SQL)", "MongoDB(NoSQL)", "Both");
        //model.addAttribute("databaseList", databaseList);
        return "search";
    }

    @PostMapping(path = "/search")
    public String submitSearchFormPgAdmin(@ModelAttribute("search")Search search, Model model) {
        List<Animal> listAnimals = new ArrayList<Animal>();
        animalRepository.findByAnimalName(search.getTopic()).forEach(listAnimals::add);
        model.addAttribute("listAnimals", listAnimals);
        System.out.println("#######" + listAnimals);
        return "search_results";
    }

//    // Search MongoDB
//    @GetMapping(path = "/searchMongoDB")
//    public ModelAndView redirectToSearchFormMongo(ModelMap model) {
//        Search search = new Search();
//        model.addAttribute("search", search);
//        model.addAttribute("attribute", "redirectToSearchFormMongo");
//        //List<String> databaseList = Arrays.asList("PgAdmin(SQL)", "MongoDB(NoSQL)", "Both");
//        //model.addAttribute("databaseList", databaseList);
//        return new ModelAndView("redirect:/localhost:9090/search", model);
//    }


    // Signup
    @GetMapping(path = "/signup")
    public String showSignupForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping(path = "/signup")
    public String submitSignupForm(@ModelAttribute("user")User user) {
        System.out.println(user);
        return "signup_success";
    }

}
