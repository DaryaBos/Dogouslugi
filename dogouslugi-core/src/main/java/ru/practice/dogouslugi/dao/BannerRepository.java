package ru.practice.dogouslugi.dao;

import org.springframework.data.repository.CrudRepository;
import ru.practice.dogouslugi.model.Banner;

public interface BannerRepository extends CrudRepository<Banner, Long> {

}
