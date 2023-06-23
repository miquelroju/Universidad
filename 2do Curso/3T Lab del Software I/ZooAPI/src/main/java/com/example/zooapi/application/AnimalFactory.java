package com.example.zooapi.application;

import com.example.zooapi.domain.animals.*;
import com.example.zooapi.domain.nutrition.AbsDiet;
import com.example.zooapi.domain.nutrition.Carnivorous;
import com.example.zooapi.domain.nutrition.Herbivore;
import com.example.zooapi.domain.nutrition.Omnivore;
import com.example.zooapi.persistence.AnimalsRepository;
import com.example.zooapi.persistence.DietRepository;
import com.example.zooapi.utilities.ConstantUtilities;
import org.springframework.stereotype.Service;

@Service
public class AnimalFactory {
    private DietRepository dietRepository;

    public AnimalFactory(DietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }

    public AbsAnimal createAnimal(int animalId) throws Exception {
        if (animalId == ConstantUtilities.DOLPHIN) {
            return new Mammal("Dolphin", generateDietCarnivours());
        }

        if (animalId == ConstantUtilities.ELEPHAN) {
            return new Mammal("Elephan", generateDietHerbivore());
        }

        if (animalId == ConstantUtilities.EAGLE) {
            return new Bird("Eagle", generateDietCarnivours());
        }

        if (animalId == ConstantUtilities.TUNA) {
            return new Fish("Tuna", generateDietCarnivours());
        }

        if (animalId == ConstantUtilities.CROCODILE) {
            return new Reptil("Crocodile", generateDietCarnivours());
        }

        throw new Exception("Invalid id");
    }

    private AbsDiet generateDietCarnivours() {
        AbsDiet diet;
        try {
            diet = this.dietRepository.findByTypeEquals(Carnivorous.class.getSimpleName()).get();
        } catch (Exception e) {
            diet = new Carnivorous();
            this.dietRepository.save(diet);
        }
        return diet;
    }


    private AbsDiet generateDietHerbivore() {
        AbsDiet diet;
        try {
            diet = this.dietRepository.findByTypeEquals(Herbivore.class.getSimpleName()).get();
        } catch (Exception e) {
            diet = new Herbivore();
            this.dietRepository.save(diet);
        }
        return diet;
    }


    private AbsDiet generateDietOmnivore() {
        AbsDiet diet;
        try {
            diet = this.dietRepository.findByTypeEquals(Omnivore.class.getSimpleName()).get();
        } catch (Exception e) {
            diet = new Omnivore();
            this.dietRepository.save(diet);
        }
        return diet;
    }

}
