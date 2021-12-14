package com.keyin.sprint2.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnimalTest {
    @Test
    void testAnimal() {
        Animal actualAnimal = new Animal();
        actualAnimal.setAnimalColor("Animal Color");
        actualAnimal.setAnimalName("Animal Name");
        actualAnimal.setAnimalOrigin("Animal Origin");
        actualAnimal.setAnimal_id(1);
        actualAnimal.setSpecies("Species");
        assertEquals("Animal Color", actualAnimal.getAnimalColor());
        assertEquals("Animal Name", actualAnimal.getAnimalName());
        assertEquals("Animal Origin", actualAnimal.getAnimalOrigin());
        assertEquals(1L, actualAnimal.getAnimal_id());
        assertEquals("Species", actualAnimal.getSpecies());
    }

    @Test
    void testAnimal1() {
        Animal actualAnimal = new Animal(1L, "Mammals", "Human", "Black", "Africa");

        assertEquals(1, actualAnimal.getAnimal_id());
        assertEquals("Mammals", actualAnimal.getSpecies());
        assertEquals("Human", actualAnimal.getAnimalName());
        assertEquals("Black", actualAnimal.getAnimalColor());
        assertEquals("Africa", actualAnimal.getAnimalOrigin());

    }
}

