package com.tecnocampus.blackjack.application;

import com.tecnocampus.blackjack.application.dto.UserDTO;
import com.tecnocampus.blackjack.domain.User;
import com.tecnocampus.blackjack.persistence.GameRepository;
import com.tecnocampus.blackjack.persistence.UserRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;
    private GameRepository gameRepository;

    public UserController(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public UserDTO createUser(UserDTO userDTO) throws Exception {
        User user = new User(userDTO);
        userRepository.save(user);
        return new UserDTO(user);
    }

    public UserDTO getUser(String userId) {
        return new UserDTO(userRepository.findById(userId).get());
    }

    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
        // gameRepository.deleteAll(user.getGames());
    }

    public List<UserDTO> getUsers() {
        ArrayList<UserDTO> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(new UserDTO(user));
        }
        return users;
    }
}
