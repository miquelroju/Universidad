package com.tcm.examen_solucio.domain;

import com.tcm.examen_solucio.application.DTO.UserDTO;
import com.tcm.examen_solucio.utilities.ConstantsUtilities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    private String email;
    private String name;
    private String password;
    private String date;

    private int numberOfGames;
    private static int numberOfGamesWon;
    private static int numberOfGamesLost;

    @OneToMany(mappedBy = "user")
    private List<Game> games = new ArrayList<>();

    public User() {};

    public User(String email, String name, String password, String date) throws Exception {
        checkPassword(password);
        this.password = password;
        this.email = email;
        this.name = name;
        this.date = date;
        this.numberOfGames = 0;
        this.numberOfGamesWon = 0;
        this.numberOfGamesLost = 0;
    }

    public User(UserDTO userDTO) throws Exception {
        checkPassword(userDTO.getPassword());
        this.email =userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.name = userDTO.getName();
        this.date = userDTO.getDate();
    };

    public static void setNumberGames(int state) {
        switch (state){
            case ConstantsUtilities.WON : numberOfGamesWon++;
            case ConstantsUtilities.LOST: numberOfGamesLost++;
            case ConstantsUtilities.DRAW: numberOfGamesLost++;
        }
    }

    private void checkPassword(String password) throws Exception {
        if(password.length() < 8) throw new Exception();
        char[] ch = password.toCharArray();
        for(char c : ch) if(Character.isDigit(c)) return;
        throw new Exception();
    }

    private void updatePassword(String newPassword) throws Exception {
        checkPassword(newPassword);
        this.password = newPassword;
    }

    private void updateName(String newName){
        this.name = newName;
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

    public int getNumberOgGamesLost() {
        return numberOfGamesLost;
    }

    public void updateUser(UserDTO userDTO) throws Exception {
        updatePassword(userDTO.getPassword());
        updateName(userDTO.getName());
    }

    public void addGame(Game game) throws Exception {
        if(game == null) throw new Exception();
        canAddGame();
        this.games.add(game);
        this.numberOfGames ++;
    }

    private void canAddGame() throws Exception {
        int count = 0;
        for(Game g : this.games)
            if(g.getState() == ConstantsUtilities.PLAYING) count ++;
        if(count >= 3) throw new Exception();
    }


}
