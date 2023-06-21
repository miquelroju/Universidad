package com.tecnocampus.blackjack.application;

import com.tecnocampus.blackjack.application.dto.GameDTO;
import com.tecnocampus.blackjack.domain.Game;
import com.tecnocampus.blackjack.domain.User;
import com.tecnocampus.blackjack.persistence.GameRepository;
import com.tecnocampus.blackjack.persistence.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private UserRepository userRepository;
    private GameRepository gameRepository;

    public GameController (UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public GameDTO createGame(GameDTO gameDTO, String userId) throws Exception {
        Game game = new Game(gameDTO);
        User user = userRepository.findById(userId).get();
        user.addGame(game);
        game.addUser(user);
        gameRepository.save(game);
        userRepository.save(user);
        return new GameDTO(game);
    }


    public GameDTO hitCard(String id) {
        Game game = gameRepository.findById(id).get();
        game.hitCard();
        gameRepository.save(game);
        return new GameDTO(game);
    }

    public GameDTO getGame(String id) {
        return new GameDTO(gameRepository.findById(id).get());
    }

    public void deleteAllGames(String id) {
        // Gets the user's id via parameter and deletes all games associated with that user
        User user = userRepository.findById(id).get();
        gameRepository.deleteAll(user.getGames());

    }
}
