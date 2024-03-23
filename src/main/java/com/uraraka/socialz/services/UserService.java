package com.uraraka.socialz.services;

import com.uraraka.socialz.dto.user.UserDTO;
import com.uraraka.socialz.entities.User;

import java.util.List;

public interface UserService {
    UserDTO saveUser(User user);
    UserDTO updateUser(User user);
    UserDTO findUserById(Long userId);
    UserDTO findUserByEmail(String email);
    List<UserDTO> getAllUsers();
}
