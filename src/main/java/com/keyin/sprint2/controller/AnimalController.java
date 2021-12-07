package com.keyin.sprint2.controller;

import com.keyin.sprint2.model.Animal;
import com.keyin.sprint2.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AnimalController {

    @Autowired
    AnimalRepo animalRepository;

    // Get all People
    @GetMapping("/animal")
    public ResponseEntity<List<Animal>> getAllAnimals(@RequestParam(required = false) String animalName) {
        try {
            List<Animal> animal = new ArrayList<Animal>();


            if (animalName == null)
                animalRepository.findAll().forEach(animal::add);
            else
                animalRepository.findByAnimalName(animalName).forEach(animal::add);

            if (animal.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(animal, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
