package com.tcm.examen_solucio.application.DTO;

import com.tcm.examen_solucio.domain.User;

public class UserDTO {

    private String id;
    private String email;
    private String name;
    private String password;
    private String date;

    private int numberOfGames;
    private int numberOfGamesWon;
    private int numberOfGamesLost;


    public UserDTO () {}

    public UserDTO (String email, String name, String password, String date) {
        this.email = email;
        this.date = date;
        this.name = name;
        this.password = password;
    }

    public UserDTO (User user) {
        if(user==null) throw new RuntimeException();
        this.id = user.getId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.date = user.getDate();
        this.email = user.getEmail();
        this.numberOfGames = user.getNumberOfGames();
        this.numberOfGamesWon = user.getNumberOfGamesWon();
        this.numberOfGamesLost = user.getNumberOgGamesLost();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    public int getNumberOfGamesLost() {
        return numberOfGamesLost;
    }
}
