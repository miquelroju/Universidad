package com.example.zooapi.domain.animals;


import com.example.zooapi.domain.nutrition.AbsDiet;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Fish extends AbsAnimal {

    public Fish(String name, AbsDiet diet) {
        super(name, diet);
    }

    @Override
    protected int getEnergyWasteOnMovement() {
        return 20;
    }
}
