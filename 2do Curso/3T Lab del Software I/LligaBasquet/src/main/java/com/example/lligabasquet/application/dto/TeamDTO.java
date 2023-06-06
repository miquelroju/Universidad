package com.example.lligabasquet.application.dto;

import com.example.lligabasquet.domain.Team;

import java.util.Iterator;
import java.util.List;

public class TeamDTO {
    private String id;
    private List<PlayerDTO> players;
    private String name;
    private String color;
    private float avgBaskets;
    private float avgRebounds;
    private final int MAX_PLAYERS = 20;

    public TeamDTO(Team team) {
        this.id = team.getId();
        this.players = team.getPlayers();
        this.name = team.getName();
        this.color = team.getColor();
        this.avgBaskets = team.getAvgBaskets();
        this.avgRebounds = team.getAvgRebounds();
    }

    public String getId() {
        return id;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
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

    public void removePlayer(String playerID) {
        Iterator<PlayerDTO> it = players.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(playerID)) {
                it.remove();
                break;
            }
        }
    }

    public void addPlayer(PlayerDTO player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public void removePlayers() {
        players.clear();
    }
}
