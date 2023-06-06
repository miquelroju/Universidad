package com.example.lligabasquet.domain;

import com.example.lligabasquet.application.dto.PlayerDTO;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class Team {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String color;
    private List<PlayerDTO> players;
    private float avgBaskets;
    private float avgRebounds;
    private final int MAX_PLAYERS = 20;

    public Team(String name, String color, List<PlayerDTO> players) throws Exception {
        if (players.isEmpty()) throw new Exception("Empty list of players");
        if (players.size() > this.MAX_PLAYERS) throw new Exception("Més jugadors dels permesos");
        this.players = players;
        this.name = name;
        this.color = color;
        Iterator<PlayerDTO> it = players.iterator();
        float totalBaskets = 0.0f;
        float totalRebounds = 0.0f;
        while (it.hasNext()) {
            totalBaskets += it.next().getBaskets();
            totalRebounds += it.next().getRebounds();
        }
        this.avgBaskets = totalBaskets / players.size();
        this.avgRebounds = totalRebounds / players.size();
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public float getAvgBaskets() {
        return avgBaskets;
    }

    public float getAvgRebounds() {
        return avgRebounds;
    }
}
