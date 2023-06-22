package com.tecnocampus.blackjack.api;

import com.tecnocampus.blackjack.application.UserController;
import com.tecnocampus.blackjack.application.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserRestController {
    private UserController userController;

    public UserRestController(UserController userController) {
        this.userController = userController;
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO userDTO) throws Exception {
        return userController.createUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userController.getAllUsers();
    }

    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        return userController.updateUser(id, userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userController.deleteUserById(id);
    }
}
