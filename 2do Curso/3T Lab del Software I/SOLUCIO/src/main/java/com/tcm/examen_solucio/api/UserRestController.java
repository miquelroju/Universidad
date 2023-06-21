package com.tcm.examen_solucio.api;

import com.tcm.examen_solucio.application.DTO.UserDTO;
import com.tcm.examen_solucio.application.UserController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    private UserController controller;

    public UserRestController(UserController controller){
        this.controller = controller;
    }

    @PostMapping("/users")
    public UserDTO createUser (@RequestBody UserDTO userDTO) throws Exception {
        return controller.createUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return controller.getAllUsers();
    }

    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable String id, @RequestBody UserDTO userDTO){
        return controller.updateUser(id, userDTO);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id){
        controller.deleteUserById(id);
    }
}
