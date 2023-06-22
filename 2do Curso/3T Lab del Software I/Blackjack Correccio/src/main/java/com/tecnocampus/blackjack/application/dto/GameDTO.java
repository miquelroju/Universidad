package com.tecnocampus.blackjack.application.dto;

import com.tecnocampus.blackjack.domain.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GameDTO {
    private String id;
    private String status;
    private int score;
    private UserDTO player;

    public GameDTO(Game game) {
        this.id = game.getId();
        this.status = game.getStatus();
        this.score = game.getScore();
        this.player = new UserDTO(game.getPlayer());
    }

    @Override
    public String toString() {
        return "GameDTO{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", score=" + score +
                ", player=" + player +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof GameDTO)) return false;

        GameDTO game = (GameDTO) o;
        return this.id.equals(game.getId());
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
