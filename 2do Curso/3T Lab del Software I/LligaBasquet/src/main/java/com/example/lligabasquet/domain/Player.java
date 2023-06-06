package com.example.lligabasquet.domain;

import java.util.UUID;

public class Player {
    private String id = UUID.randomUUID().toString();
    private String name;
    private float height;
    private int baskets;
    private int rebounds;
    private int dorsal;

    public Player(String name, float height, int baskets, int rebounds, int dorsal) {
        this.name = name;
        this.height = height;
        this.baskets = baskets;
        this.rebounds = rebounds;
        this.dorsal = dorsal;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getHeight() {
        return height;
    }

    public int getBaskets() {
        return baskets;
    }

    public int getRebounds() {
        return rebounds;
    }

    public int getDorsal() {
        return dorsal;
    }

    @Override
    public String toString() {
        return
                "Jugador amb id: " + id + ", de nom: " + name +
                        ", amb altura: " + height + ", que ha encanastat "
                        + baskets + " canastes, ha rebotat la pilota "
                        + rebounds + " vegades i porta el dorsal " + dorsal;
    }
}