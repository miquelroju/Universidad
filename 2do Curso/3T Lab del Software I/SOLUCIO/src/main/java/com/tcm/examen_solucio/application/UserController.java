package com.tcm.examen_solucio.application;

import com.tcm.examen_solucio.application.DTO.UserDTO;
import com.tcm.examen_solucio.domain.User;
import com.tcm.examen_solucio.persistence.UserRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    public UserDTO createUser(UserDTO userDTO) throws Exception {
        User user = new User(userDTO);
        repository.save(user);
        return new UserDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> result = new ArrayList<>();

        Iterator<User> iterator = this.repository.findAll().iterator();
        iterator.forEachRemaining(result::add);

        return result.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }


    public UserDTO updateUser(String userId, UserDTO userDTO) {
        User userToUpdate = repository.findById(userId).get();
        userToUpdate.updateUser(userDTO);
        this.repository.save(userToUpdate);
        return new UserDTO(userToUpdate);
    }

    public void deleteUserById(String id) {
        repository.deleteById(id);
    }
}
