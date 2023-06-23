package com.example.zooapi.application;

import com.example.zooapi.domain.animals.AbsAnimal;
import com.example.zooapi.persistence.AnimalsRepository;

@org.springframework.stereotype.Controller
public class Controller {
    private AnimalsRepository animalsRepository;
    private AnimalFactory animalFactory;

    Controller(AnimalsRepository animalsRepository, AnimalFactory animalFactory) {
        this.animalsRepository = animalsRepository;
        this.animalFactory = animalFactory;
    }

    public void createAnimalsTest(int animalId) throws Exception {
        AbsAnimal animal = this.animalFactory.createAnimal(animalId);
        animalsRepository.save(animal);
    }

}
