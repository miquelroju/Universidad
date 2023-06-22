package com.tecnocampus.blackjack.api;

import com.tecnocampus.blackjack.application.GameController;
import com.tecnocampus.blackjack.application.dto.GameDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameRestController {
    private GameController controller;

    public GameRestController(GameController controller){
        this.controller = controller;
    }

    @PostMapping("users/{id}/games")
    public GameDTO createGame(@PathVariable String id) throws Exception {
        return controller.createGame(id);
    }

    @GetMapping("users/{id}/games")
    public List<GameDTO> getAllGames (@PathVariable String id){
        return controller.getAllGamesOfUser(id);
    }

    @PostMapping("users/{userId}/games/{gameId}")
    public GameDTO card(@PathVariable String userId, @PathVariable String gameId) throws Exception {
        return controller.getCard(userId, gameId);
    }

    @PutMapping("users/{userId}/games/{gameId}")
    public GameDTO setGameToStand(@PathVariable String userId, @PathVariable String gameId) throws Exception {
       return controller.setToStand(userId, gameId);
    }

    @GetMapping("users/{userId}/games/{gameId}")
    public GameDTO getGame(@PathVariable String userId, @PathVariable String gameId) throws Exception {
        return controller.getGame(userId, gameId);
    }
}
