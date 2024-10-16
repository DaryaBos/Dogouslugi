package ru.practice.dogouslugi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.practice.dogouslugi.dao.DogRepository;
import ru.practice.dogouslugi.model.Dog;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {
    private final DogRepository dogRepository;
    private static final Logger logger = LoggerFactory.getLogger(DogService.class);

    public DogService(DogRepository dogRepository) {
      this.dogRepository = dogRepository;
    }

    public List<Dog> listDog() {
        List<Dog> list = new LinkedList<>();
        Iterable<Dog> all = dogRepository.findAll();
        all.forEach(list::add);
        return list;
    }

    public Long addDog(Dog dog) {
        try {
            dog = dogRepository.save(dog);
            logger.info(String.format("Добавлена собачка = %s ", dog.getName()));
            return dog.getId();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Dog getDog(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);
        return dog.orElse(null);
    }

    public void deleteDog(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);
        dog.ifPresent(dogRepository::delete);
    }
}
