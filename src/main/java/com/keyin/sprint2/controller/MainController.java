// This is the MainController class

package com.keyin.sprint2.controller;

import com.keyin.sprint2.model.Animal;
import com.keyin.sprint2.model.Search;
import com.keyin.sprint2.model.User;
import com.keyin.sprint2.repository.AnimalRepo;
import com.keyin.sprint2.repository.SearchRepository;
import com.keyin.sprint2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Front-end webpage routes for the user
@Controller
public class MainController {
    @Autowired
    private AnimalRepo animalRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private SearchRepository searchRepo;

    // Signout path
    @GetMapping(path = "/signout")
    public String getLogOutPage() {

        return "signout";
    }

    // Search PgAdmin path
    @GetMapping(path = "/searchPgadmin")
    public String showSearchForm(Model model) {
        Search search = new Search();
        model.addAttribute("search", search);
        //List<String> databaseList = Arrays.asList("PgAdmin(SQL)", "MongoDB(NoSQL)", "Both");
        //model.addAttribute("databaseList", databaseList);
        return "search";
    }

    // search path
    @PostMapping(path = "/search")
    public String submitSearchFormPgAdmin(@ModelAttribute("search")Search search, Model model) {
        List<Animal> listAnimals = new ArrayList<Animal>();
        animalRepo.findByAnimalName(search.getTopic()).forEach(listAnimals::add);
        model.addAttribute("listAnimals", listAnimals);
        System.out.println("#######" + listAnimals);
        //searchRepo.insertWithEntityManager(new Search(search.getTopic(), search.getDatabase()));
        return "search_results";
    }


    // Signup path
    @GetMapping(path = "/signup")
    public String showSignupForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    // Signup path
    @PostMapping(path = "/signup")
    public String submitSignupForm(@ModelAttribute("user")User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
        System.out.println(user);
        return "signup_success";
    }

    // Users path
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

}
