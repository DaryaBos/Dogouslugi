package ru.practice.dogouslugi.dao;

import org.springframework.data.repository.CrudRepository;
import ru.practice.dogouslugi.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
