package com.tecnocampus.blackjack.application.dto;

import com.tecnocampus.blackjack.domain.User;

public class UserDTO {
    private String id;
    private String username;
    private String email;
    private String password;
    private String date;

    private int numberGames;
    private int numberWonGames;
    private int numberLostGames;

    public UserDTO() {}

    public UserDTO (String email, String username, String password, String date) {
        this.email = email;
        this.date = date;
        this.username = username;
        this.password = password;
    }

    public UserDTO (User user) {
        if(user==null) throw new RuntimeException();
        this.id = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.date = user.getDate();
        this.email = user.getEmail();
        this.numberGames = user.getNumberGames();
        this.numberWonGames = user.getNumberWonGames();
        this.numberLostGames = user.getNumberLostGames();
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

    public int getNumberGames() {
        return numberGames;
    }

    public int getNumberWonGames() {
        return numberWonGames;
    }

    public int getNumberLostGames() {
        return numberLostGames;
    }

}
