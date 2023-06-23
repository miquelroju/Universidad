package com.example.zooapi.domain.nutrition;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity(name = "diets")
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbsDiet {
    @Id
    protected String id = UUID.randomUUID().toString();

    protected String type = getClass().getSimpleName();

    public AbsDiet() {
    }

    public abstract int feed();
}
