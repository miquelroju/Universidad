package com.tecnocampus.blackjack.application.dto;

import com.tecnocampus.blackjack.domain.Game;

public class GameDTO {
    private String id;
    private int status;
    private int score;

    public GameDTO() {}

    public GameDTO(Game game) {
        if (user==null) throw new RuntimeException();
        this.id = game.getId();
        this.status = game.getStatus();
        this.score = game.getScore();
    }

    public String getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }
}
