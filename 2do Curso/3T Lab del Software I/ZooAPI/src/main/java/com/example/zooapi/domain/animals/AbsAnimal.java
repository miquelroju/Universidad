package com.example.zooapi.domain.animals;

import com.example.zooapi.domain.nutrition.AbsDiet;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "animals")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbsAnimal {
    @Id
    protected String id = UUID.randomUUID().toString();
    @ManyToOne
    protected AbsDiet diet;
    protected String name;

    protected int energy = 0;
    protected static final int MAX_ENERGY = 100;

    public AbsAnimal(String name, AbsDiet diet) {
        this.name = name;
        this.diet = diet;
    }

    public void feed() {
        this.energy += this.diet.feed();
        if (energy > MAX_ENERGY) energy = MAX_ENERGY;
    }

    public void move() {
        this.energy -= getEnergyWasteOnMovement();
        if (this.energy < 0) this.energy = 0;
    }

    protected abstract int getEnergyWasteOnMovement();

    public String getName() {
        return name;
    }
}
