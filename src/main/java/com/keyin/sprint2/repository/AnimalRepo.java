// This is the AnimalRepo class

package com.keyin.sprint2.repository;

import com.keyin.sprint2.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "animal", path = "animal")
public interface AnimalRepo extends JpaRepository<Animal, Long> {


        List<Animal> findByAnimalName(@Param("animalName") String animalName);

        @Query(value = "SELECT * FROM Product animal", nativeQuery = true)
        List<Animal> findAllAnimals();

//        List<Animal> findByAnimal_id(@Param("animal_id") String animal_id);
//        List<Animal> findBySpecies(@Param("species") String species);
//        List<Animal> findByAnimalColor(@Param("animalColor") String animalColor);
//        List<Animal> findByAnimalOrigin(@Param("animalOrigin") String animalOrigin);

}
