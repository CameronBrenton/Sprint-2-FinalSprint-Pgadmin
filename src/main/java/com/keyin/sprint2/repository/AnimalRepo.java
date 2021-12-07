package com.keyin.sprint2.repository;

import com.keyin.sprint2.model.Animal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "animal", path = "animal")
public interface AnimalRepo extends PagingAndSortingRepository<Animal, Long> {

        List<Animal> findByAnimalName(@Param("species") String species);

}
