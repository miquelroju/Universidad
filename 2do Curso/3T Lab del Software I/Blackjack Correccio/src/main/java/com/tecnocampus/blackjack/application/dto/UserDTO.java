package com.tecnocampus.blackjack.application.dto;

import com.tecnocampus.blackjack.domain.Game;
import com.tecnocampus.blackjack.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String id;
    private String username;
    private String email;
    private String password;
    private String date;
    private int wonGames;
    private int lostGames;
    private int drawGames;
    private int standingGames;
    private int activeGames;

    private List<Game> games = new ArrayList<com.tecnocampus.blackjack.domain.Game>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.date = user.getDate();
        this.wonGames = user.getWonGames();
        this.lostGames = user.getLostGames();
        this.drawGames = user.getDrawGames();
        this.standingGames = user.getStandingGames();
        this.activeGames = user.getActiveGames();
        this.games.addAll(user.getGames());
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public int getWonGames() {
        return wonGames;
    }

    public int getLostGames() {
        return lostGames;
    }

    public int getDrawGames() {
        return drawGames;
    }

    public int getStandingGames() {
        return standingGames;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                ", wonGames=" + wonGames +
                ", lostGames=" + lostGames +
                ", drawGames=" + drawGames +
                ", standingGames=" + standingGames +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof UserDTO)) return false;

        UserDTO userDTO = (UserDTO) o;

        return this.id.equals(userDTO.getId());
    }

    public void startGame() {
        this.activeGames++;
    }

    public List<GameDTO> getGames() {
        List<GameDTO> gameDTOs = new ArrayList<>();
        for (Game game : games) {
            gameDTOs.add(new GameDTO(game));
        }
        return gameDTOs;
    }
}
