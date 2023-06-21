package com.tecnocampus.blackjack.api;

import com.tecnocampus.blackjack.application.GameController;
import com.tecnocampus.blackjack.application.UserController;
import com.tecnocampus.blackjack.application.dto.GameDTO;
import com.tecnocampus.blackjack.application.dto.UserDTO;
import com.tecnocampus.blackjack.domain.Game;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlackjackRestController {
    private UserController userController;
    private GameController gameController;

    public BlackjackRestController(UserController userController, GameController gameController) {
        this.userController = userController;
        this.gameController = gameController;
    }

    @PostMapping("/users")
    public UserDTO createUser(UserDTO userDTO) throws Exception {
        return userController.createUser(userDTO);
    }

    @PostMapping("/games")
    public GameDTO createGame(GameDTO gameDTO, String userId) throws Exception {
        return gameController.createGame(gameDTO, userId);
    }

    @PostMapping("/users/games/{id}")
    public GameDTO hit(@PathVariable String id) throws Exception {
        return gameController.hitCard(id);
    }

    @PutMapping("/users/{id}")
    public void setUser(@PathVariable String id) {
        UserDTO user = userController.getUser(id);
        user.startGame();
    }

    @PutMapping("/users/{userId}/games/{gameId}")
    public void setGame(@PathVariable String userId, @PathVariable String gameId) {
        // Gets the game from the user and sets its status as "Standing"
        GameDTO game = gameController.getGame(gameId);
        game.setStatus(Game.STAND);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userController.getUsers();
    }

    @GetMapping("/users/{id}/games")
    public List<GameDTO> getGames(@PathVariable String id) {
        return userController.getUser(id).getGames();
    }

    @GetMapping("/users/{userId}/games/{gameId}")
    public GameDTO getGame(@PathVariable String userId, @PathVariable String gameId) {
        return gameController.getGame(gameId);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userController.deleteUser(id);
        gameController.deleteAllGames(id);
    }

}
