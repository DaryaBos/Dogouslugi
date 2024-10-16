package ru.practice.dogouslugi.dao;

import org.springframework.data.repository.CrudRepository;
import ru.practice.dogouslugi.model.Grooming;

public interface GroomingRepository extends CrudRepository<Grooming, Long> {
}
