package com.tecnocampus.blackjack.domain;

import com.tecnocampus.blackjack.application.dto.GameDTO;
import com.tecnocampus.blackjack.application.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity(name = "user")
public class User {

    @Id
    private String id = UUID.randomUUID().toString();

    private String email;
    private String username;
    private String password;
    private String date;
    private int activeGames;
    private int wonGames;
    private int lostGames;
    private int drawGames;
    private int standingGames;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> games = new ArrayList<>();

    public User(String email, String username, String password, String date) throws Exception {
        // Check if password is valid, which means it must have at least 8 characters and one of them must be a number
        if (password.length() < 8) {
            throw new Exception("Password must have at least 8 characters");
        }
        boolean hasNumber = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasNumber = true;
                break;
            }
        }
        if (!hasNumber) {
            throw new Exception("Password must have at least one number");
        }
        this.email = email;
        this.username = username;
        this.password = password;
        this.date = date;
        this.activeGames = 0;
        this.wonGames = 0;
        this.lostGames = 0;
        this.drawGames = 0;
        this.standingGames = 0;
        this.games = new ArrayList<>();
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.email = userDTO.getEmail();
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.date = userDTO.getDate();
        this.wonGames = userDTO.getWonGames();
        this.lostGames = userDTO.getLostGames();
        this.drawGames = userDTO.getDrawGames();
        this.standingGames = userDTO.getStandingGames();
    }

    public void playingGame() {
        this.activeGames++;
    }

    public void finishedGame() {
        this.activeGames--;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public void setUsername (String username) throws Exception {
        this.username = username;
    }

    public void addGame(Game game) {
        switch (game.getStatus()) {
            case "WON" -> this.wonGames++;
            case "LOST" -> this.lostGames++;
            case "DRAW" -> this.drawGames++;
            case "STANDING" -> this.standingGames++;
        }
    }

    public List<Game> getGames() {
        return this.games;
    }
}
