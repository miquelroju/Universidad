package com.example.zooapi.domain.nutrition;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Herbivore extends AbsDiet {

    private int energy = 20;

    @Override
    public int feed() {
        return energy;
    }

}
