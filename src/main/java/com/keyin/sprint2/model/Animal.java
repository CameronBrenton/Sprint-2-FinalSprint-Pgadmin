package com.keyin.sprint2.model;
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animal_id;
    private String species;
    private String animalName;
    private String animalColor;
    private String animalOrigin;

    public Animal() {
    }

    public Animal(long animal_id, String species, String animalName, String animalColor, String animalOrigin) {
        this.animal_id = animal_id;
        this.species = species;
        this.animalName = animalName;
        this.animalColor = animalColor;
        this.animalOrigin = animalOrigin;
    }



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


