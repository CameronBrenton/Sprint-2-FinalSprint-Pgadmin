package com.keyin.sprint2.repository;

import com.keyin.sprint2.model.Animal;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnimalRepoTest {

    private AnimalRepo animalRepo;

    @Test
    public void testFindAnimals(){
        List<Animal> listAnimals = (List<Animal>) animalRepo.findAllAnimals();
        System.out.println(listAnimals);
        Assertions.assertNull(listAnimals);
    }

    @Test
    public void testFindAllAnimals(){
        List<Animal> animals = animalRepo.findByAnimalName("Bear");
        System.out.println(animals);
        Assertions.assertNotNull(animals);
    }

}
