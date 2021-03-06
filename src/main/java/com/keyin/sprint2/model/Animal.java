

package com.keyin.sprint2.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animal_id;

    private String species;
    private String animalName;
    private String animalColor;
    private String animalOrigin;

    // Empty Constructor
    public Animal() {
    }

    // Parameterized Constructor
    public Animal(long animal_id, String species, String animalName, String animalColor, String animalOrigin) {
        this.animal_id = animal_id;
        this.species = species;
        this.animalName = animalName;
        this.animalColor = animalColor;
        this.animalOrigin = animalOrigin;
    }

    // Getters and Setters
    public long getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(long animal_id) {
        this.animal_id = animal_id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalOrigin() {
        return animalOrigin;
    }

    public void setAnimalOrigin(String animalOrigin) {
        this.animalOrigin = animalOrigin;
    }
}


