package com.uraraka.socialz.api;

import com.uraraka.socialz.dto.user.UserDTO;
import com.uraraka.socialz.entities.User;
import com.uraraka.socialz.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> usersDTO = userService.getAllUsers();
        return ResponseEntity.ok().body(usersDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userId){
        UserDTO userDTO = userService.findUserById(userId);
        return ResponseEntity.ok().body(userDTO);
    }
}
