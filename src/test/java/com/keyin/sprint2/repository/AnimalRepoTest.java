package com.keyin.sprint2.repository;

import com.keyin.sprint2.model.Animal;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnimalRepoTest {

    private AnimalRepo animalRepo;

    @Test
    public void testFindAnimals(){
        List<Animal> listAnimals = animalRepo.findAll();
        Assert.assertTrue(listAnimals != null);
    }

}
