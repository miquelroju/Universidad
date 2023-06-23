package com.example.zooapi.domain.animals;

import com.example.zooapi.domain.nutrition.AbsDiet;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Bird extends AbsAnimal {

    public Bird(String name, AbsDiet diet) {
        super(name, diet);
    }

    @Override
    protected int getEnergyWasteOnMovement() {
        return 10;
    }
}
