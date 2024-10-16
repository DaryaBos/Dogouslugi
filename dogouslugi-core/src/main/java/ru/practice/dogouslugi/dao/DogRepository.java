package ru.practice.dogouslugi.dao;

import org.springframework.data.repository.CrudRepository;
import ru.practice.dogouslugi.model.Dog;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
