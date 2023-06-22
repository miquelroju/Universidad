package com.tecnocampus.blackjack.domain;

import com.tecnocampus.blackjack.application.dto.GameDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity(name = "game")
public class Game {
    public final static String PLAYING = "Playing";
    public final static String WON = "Won";
    public final static String LOST = "Lost";
    public final static String DRAW = "Draw";
    public final static String STAND = "Stand";

    @Id
    private String id = UUID.randomUUID().toString();
    private String status;
    private int score;
    @OneToOne
    private User player;

    public Game (User player) {
        if (player.getActiveGames() >= 3) {
            throw new RuntimeException("You can't play more than 3 games at the same time");
        }
        this.status = Game.PLAYING;
        this.score = 0;
        this.player = player;
    }

    public Game(GameDTO gameDTO) {
        this.id = gameDTO.getId();
        this.status = gameDTO.getStatus();
        this.score = gameDTO.getScore();
        this.player = new User(gameDTO.getPlayer());
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void hitCard() {
        this.score += (int) (Math.random() * 10 + 1);
        if (this.score > 21) {
            setGameToLost();
        }
        if (this.score == 21) {
            setGameToWon();
        }
    }

    public void croupierHitCard() {
        if (this.status.equals(Game.STAND)) {
            // Croupier hits a number between 13 and 25, if the number is greater than 21, the game is set to won
            // if the number is greater than the player's score and lower than 21, the game is set to lost
            // if the number is equal to the player's score, the game is set to draw
            int croupierScore = (int) (Math.random() * 13 + 13);
            if (croupierScore > 21) {
                setGameToWon();
            } else if (croupierScore > this.score && croupierScore < 21) {
                setGameToLost();
            } else if (croupierScore == this.score) {
                setGameToDraw();
            }
        }
    }

    public void stand() {
        this.status = Game.STAND;
    }

    public void setGameToLost () {
        this.status = Game.LOST;
    }

    public void setGameToWon () {
        this.status = Game.WON;
    }

    public void setGameToDraw() {
        this.status = Game.DRAW;
    }


    public void addUser(User user) {
        this.player = user;
    }

}
