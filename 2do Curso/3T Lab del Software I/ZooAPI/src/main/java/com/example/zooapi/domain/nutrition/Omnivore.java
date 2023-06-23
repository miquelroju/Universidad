package com.example.zooapi.domain.nutrition;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Omnivore extends AbsDiet {

    private int energy = 40;

    @Override
    public int feed() {
        return energy;
    }
}
