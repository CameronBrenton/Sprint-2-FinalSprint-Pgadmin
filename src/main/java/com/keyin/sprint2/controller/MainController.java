package com.keyin.sprint2.controller;

import com.keyin.sprint2.model.Animal;
import com.keyin.sprint2.model.Search;
import com.keyin.sprint2.model.User;
import com.keyin.sprint2.repository.AnimalRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Front-end webpage routes for the user
@Controller
public class MainController {
    private AnimalController animalController;
    private AnimalRepo animalRepository;

    // Get Mappings
    @GetMapping(path = "/login")
    public String getLogInPage() {

        return "logIn";
    }

    @GetMapping(path = "/logout")
    public String getLogOutPage() {

        return "logout";
    }

    // Search
    @GetMapping(path = "/search")
    public String showSearchForm(Model model) {
        Search search = new Search();
        model.addAttribute("search", search);
        List<String> databaseList = Arrays.asList("PgAdmin(SQL)", "MongoDB(NoSQL)", "Both");
        model.addAttribute("databaseList", databaseList);
        List<Animal> listAnimals = new ArrayList<Animal>();
        animalRepository.findAll().forEach(listAnimals::add);
//        List<Animal> listAnimals = null;
//        try{
//            listAnimals = animalRepository.findAllAnimals();
//        }catch(Exception e){
//            System.out.println(e);
//        }
        model.addAttribute("listAnimals", listAnimals);
        System.out.println("#######" + listAnimals);
        return "search";
    }

    @PostMapping(path = "/search")
    public String submitSearchForm(@ModelAttribute("search")Search search) {
        System.out.println(search);
        return "search_results";
    }

    @GetMapping(path = "/searchtest")
    public String showSearchFormTest(Model model) {
        Iterable<Animal> listAnimals = null;
        try{
            listAnimals = animalRepository.findAll();
        }catch(Exception e){
            System.out.println(e);
        }

        model.addAttribute("listAnimals", listAnimals);
        System.out.println("#######" + listAnimals);
        return "search";
    }


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

    // Results
    @GetMapping(path = "/results")
    public String getResultsPage() {

        return "results";
    }

    // Error
//    @GetMapping(path = "/error")
//    public String getErrorPage() {
//
//        return "error";
//    }

}
