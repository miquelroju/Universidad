package com.tcm.examen_solucio.application.DTO;

import com.tcm.examen_solucio.domain.Game;

public class GameDTO {

    private String id;
    private int state;
    private int score;

    public GameDTO () {}

    public GameDTO (Game game) {
        if(user==null) throw new RuntimeException();
        this.id = game.getId();
        this.state = game.getState();
        this.score = game.getScore();
    }

    public String getId() {
        return id;
    }

    public int getState() {
        return state;
    }

    public int getScore() {
        return score;
    }
}
