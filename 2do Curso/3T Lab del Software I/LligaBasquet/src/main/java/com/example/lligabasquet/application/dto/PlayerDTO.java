package com.example.lligabasquet.application.dto;

public class PlayerDTO {
    private String id;
    private String name;
    private float height;
    private int baskets;
    private int rebounds;
    private int dorsal;

    public PlayerDTO(PlayerDTO player) {
        this.id = player.getId();
        this.name = player.getName();
        this.height = player.getHeight();
        this.baskets = player.getBaskets();
        this.rebounds = player.getRebounds();
        this.dorsal = player.getDorsal();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getHeight() {
        return this.height;
    }

    public int getBaskets() {
        return this.baskets;
    }

    public int getRebounds() {
        return this.rebounds;
    }

    public int getDorsal() {
        return this.dorsal;
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
