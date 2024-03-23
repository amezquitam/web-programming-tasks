package com.uraraka.socialz.services;

import com.uraraka.socialz.dto.user.UserDTO;
import com.uraraka.socialz.dto.user.UserMapper;
import com.uraraka.socialz.entities.User;
import com.uraraka.socialz.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO saveUser(User user) {
        User userSaved = userRepository.save(user);
        return userMapper.userEntityToUserDTO(userSaved);
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

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::userEntityToUserDTO).collect(Collectors.toList());
    }

}
