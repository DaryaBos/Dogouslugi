package ru.practice.dogouslugi.dao;

import org.springframework.data.repository.CrudRepository;
import ru.practice.dogouslugi.model.Requisition;

public interface RequisitionRepository extends CrudRepository<Requisition, Integer> {

}
