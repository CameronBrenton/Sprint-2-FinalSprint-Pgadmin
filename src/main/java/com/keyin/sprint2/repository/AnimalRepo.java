package com.keyin.sprint2.repository;

import com.keyin.sprint2.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "animal", path = "animal")
public interface AnimalRepo extends CrudRepository<Animal, Long> {

        List<Animal> findByAnimalName(@Param("animalName") String animalName);
        Iterable<Animal> findAll();
//        List<Animal> findByAnimal_id(@Param("animal_id") String animal_id);
//        List<Animal> findBySpecies(@Param("species") String species);
//        List<Animal> findByAnimalColor(@Param("animalColor") String animalColor);
//        List<Animal> findByAnimalOrigin(@Param("animalOrigin") String animalOrigin);

}
