package com.tcm.examen_solucio.domain;

import com.tcm.examen_solucio.utilities.ConstantsUtilities;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Game {


    @Id
    private String id = UUID.randomUUID().toString();
    private int state;
    private int score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Game() {
        this.state = ConstantsUtilities.PLAYING;
        this.score = 0;
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


    public void setUser(User user) throws Exception {
        if(user == null) throw new Exception();
        this.user = user;
    }

    public void checkValidUser(String userId) throws Exception {
        if(this.user == null) throw new Exception();
        if(!user.getId().equals(userId)) throw new Exception();
    }

    public void extractCard() throws Exception {
        if(this.state != ConstantsUtilities.PLAYING) throw new Exception();
        int card = getCard();
        this.score = this.score + card;
        setState();
    }

    private int getCard(){
        return (int)(Math.random()*(12-1)) + 1;
    }

    private void setState() {
        if(this.score == 21) this.state = ConstantsUtilities.WON;
        else if (this.score > 21) this.state = ConstantsUtilities.LOST;
        User.setNumberGames(this.state);
    }

    public void setStand() throws Exception {
        if(this.state != ConstantsUtilities.PLAYING) throw new Exception();
        int machineScore = (int)(Math.random()*(25-13)) + 13;
        if(machineScore > 21) this.state = ConstantsUtilities.WON;
        else if(machineScore == this.score) this.state = ConstantsUtilities.DRAW;
        else this.state = ConstantsUtilities.LOST;
        User.setNumberGames(this.state);
    }


}
