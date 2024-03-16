package com.uraraka.socialz.services;

import com.uraraka.socialz.dto.user.UserDTO;
import com.uraraka.socialz.dto.user.UserMapper;
import com.uraraka.socialz.entities.User;
import com.uraraka.socialz.repositories.UserRepository;

import java.util.Objects;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser(User user) {
        User userSaved = userRepository.save(user);
        return UserMapper.userEntityToUserDTO(userSaved);
    }

    @Override
    public UserDTO updateUser(User user) {
        if (Objects.isNull(user.getUserId())) {
            throw new IllegalArgumentException("User passed doesn't exist");
        }
        return saveUser(user);
    }

    @Override
    public UserDTO findUserById(Long userId) {
        return null;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return null;
    }

}
