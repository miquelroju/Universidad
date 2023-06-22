package com.tecnocampus.blackjack.domain;

import com.tecnocampus.blackjack.application.dto.UserDTO;
import com.tecnocampus.blackjack.utilities.ConstantsUtilities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "user")
public class User {

    @Id
    private String id = UUID.randomUUID().toString();

    private String email;
    private String username;
    private String password;
    private String date;

    private int numberGames;
    private static int numberWonGames;
    private static int numberLostGames;

    @OneToMany
    private List<Game> games = new ArrayList<>();

    public User() {};

    public User(String email, String username, String password, String date) throws Exception {
        checkPassword(password);
        this.password = password;
        this.email = email;
        this.username = username;
        this.date = date;
        this.numberGames = 0;
        this.numberWonGames = 0;
        this.numberLostGames = 0;
    }

    public User(UserDTO userDTO) throws Exception {
        checkPassword(userDTO.getPassword());
        this.email =userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.username = userDTO.getUsername();
        this.date = userDTO.getDate();
    }

    public static void setNumberGames(int state) {
        switch (state){
            case ConstantsUtilities.WON : numberWonGames++;
            case ConstantsUtilities.LOST: numberLostGames++;
            case ConstantsUtilities.DRAW: numberLostGames++;
        }
    }

    private void checkPassword(String password) throws Exception {
        if(password.length() < 8) throw new Exception();
        char[] ch = password.toCharArray();
        for (char c : ch) if (Character.isDigit(c)) return;
        throw new Exception();
    }

    private void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    private void updateUsername(String newUsername) {
        this.username = newUsername;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDate() {
        return this.date;
    }

    public int getNumberGames() {
        return this.numberGames;
    }

    public int getNumberWonGames() {
        return this.numberWonGames;
    }

    public int getNumberLostGames() {
        return this.numberLostGames;
    }

    public void updateUser(UserDTO userDTO) {
        updatePassword(userDTO.getPassword());
        updateUsername(userDTO.getUsername());
    }

    public void addGame(Game game) throws Exception {
        if (game == null) throw new Exception();
        canAddGame();
        this.games.add(game);
        this.numberGames++;
    }

    private void canAddGame() throws Exception {
        int count = 0;
        for (Game g : this.games)
            if (g.getStatus() == ConstantsUtilities.PLAYING) count++;
        if (count >= 3) throw new Exception();
    }

}
