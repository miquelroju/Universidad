package com.tecnocampus.blackjack.domain;

import com.tecnocampus.blackjack.application.dto.GameDTO;
import com.tecnocampus.blackjack.utilities.ConstantsUtilities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Entity(name = "game")
public class Game {

    @Id
    private String id = UUID.randomUUID().toString();
    private int status;
    private int score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User player;

    public Game() {
        this.status = ConstantsUtilities.PLAYING;
        this.score = 0;
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

    public void setUser(User user) throws Exception {
        if(user == null) throw new Exception();
        this.player = user;
    }

    public void checkValidUser(String userId) throws Exception {
        if(this.player == null) throw new Exception();
        if(!player.getId().equals(userId)) throw new Exception();
    }

    public void extractCard() throws Exception {
        if(this.status != ConstantsUtilities.PLAYING) throw new Exception();
        int card = getCard();
        this.score = this.score + card;
        setStatus();
    }

    private int getCard() {
        return (int) (Math.random() * (12-1)) + 1;
    }

    private void setStatus() {
        if (this.score > 21) {
            this.status = ConstantsUtilities.LOST;
        } else if (this.score == 21) {
            this.status = ConstantsUtilities.WON;
        }
        User.setNumberGames(this.status);
    }

    public void setStand() throws Exception {
        if (this.status != ConstantsUtilities.PLAYING) throw new Exception();
        int machineScore = (int)(Math.random()*(25-13)) + 13;
        if (machineScore > 21) this.status = ConstantsUtilities.WON;
        else if (machineScore == this.score) this.status = ConstantsUtilities.DRAW;
        else this.status = ConstantsUtilities.LOST;
        User.setNumberGames(this.status);
    }

}
