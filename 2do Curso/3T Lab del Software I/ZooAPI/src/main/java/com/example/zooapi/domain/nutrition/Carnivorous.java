package com.example.zooapi.domain.nutrition;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Carnivorous extends AbsDiet {


    private int energy = 50;

    @Override
    public int feed() {
        return energy;
    }
}
