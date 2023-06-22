package com.tecnocampus.blackjack.application;

import com.tecnocampus.blackjack.application.dto.UserDTO;
import com.tecnocampus.blackjack.domain.User;
import com.tecnocampus.blackjack.persistence.GameRepository;
import com.tecnocampus.blackjack.persistence.UserRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserDTO userDTO) throws Exception {
        User user = new User(userDTO);
        userRepository.save(user);
        return new UserDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> result = new ArrayList<>();
        Iterator<User> iterator = this.userRepository.findAll().iterator();
        iterator.forEachRemaining(result::add);
        return result.stream().map(x -> new UserDTO(x)).collect(java.util.stream.Collectors.toList());
    }

    public UserDTO updateUser(String userId, UserDTO userDTO) {
        User userToUpdate = userRepository.findById(userId).get();
        userToUpdate.updateUser(userDTO);
        this.userRepository.save(userToUpdate);
        return new UserDTO(userToUpdate);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }


}
