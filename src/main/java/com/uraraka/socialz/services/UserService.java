package com.uraraka.socialz.services;

import com.uraraka.socialz.dto.user.UserDTO;
import com.uraraka.socialz.entities.User;

public interface UserService {
    UserDTO saveUser(User user);
    UserDTO updateUser(User user);
    UserDTO findUserById(Long userId);
    UserDTO findUserByEmail(String email);
}
