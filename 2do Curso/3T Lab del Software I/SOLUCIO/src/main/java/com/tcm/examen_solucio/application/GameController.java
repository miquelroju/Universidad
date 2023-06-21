package com.tcm.examen_solucio.application;


import com.tcm.examen_solucio.application.DTO.GameDTO;
import com.tcm.examen_solucio.domain.Game;
import com.tcm.examen_solucio.domain.User;
import com.tcm.examen_solucio.persistence.GameRepository;
import com.tcm.examen_solucio.persistence.UserRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GameController {

    private UserRepository userRepository;
    private GameRepository gameRepository;

    public GameController( UserRepository userRepository, GameRepository gameRepository){
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }
    public GameDTO createGame(String userId) throws Exception {
        Game game = new Game();
        User user = userRepository.findById(userId).get();
        user.addGame(game);
        game.setUser(user);
        gameRepository.save(game);
        return new GameDTO(game);
    }

    public List<GameDTO> getAllGamesOfUser(String userId) {
        List<Game> result = new ArrayList<>();
        User user = userRepository.findById(userId).get();
        Iterator<Game> iterator = this.gameRepository.findAllByUser(user).iterator();
        iterator.forEachRemaining(result::add);
        return result.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
    }


    public GameDTO getCard(String userId, String gameId) throws Exception {
        Game game = gameRepository.findById(gameId).get();
        game.checkValidUser(userId);
        game.extractCard();
        gameRepository.save(game);
        return new GameDTO(game);
    }

    public GameDTO setToStand(String userId, String gameId) throws Exception {
        Game game = gameRepository.findById(gameId).get();
        game.checkValidUser(userId);
        game.setStand();
        gameRepository.save(game);
        return new GameDTO(game);
    }

    public GameDTO getGame(String userId, String gameId) throws Exception {
        Game game = gameRepository.findById(gameId).get();
        game.checkValidUser(userId);
        return new GameDTO(game);
    }
}
