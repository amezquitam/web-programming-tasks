package com.uraraka.socialz.dto.user;

import com.uraraka.socialz.dto.message.MessageMapper;
import com.uraraka.socialz.dto.suggestion.SuggestionMapper;
import com.uraraka.socialz.entities.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static User userDTOtoUserEntity(UserDTO userDTO) {
        var messages = userDTO.messages().stream()
                .map(MessageMapper::MessageDTOtoMessageEntity)
                .collect(Collectors.toList());

        var suggestion = userDTO.suggestions().stream()
                .map(SuggestionMapper::SuggestionDTOtoSuggestionEntity)
                .collect(Collectors.toList());

        return User.builder()
                .userId(userDTO.id())
                .firstname(userDTO.firstname())
                .lastname(userDTO.lastname())
                .username(userDTO.username())
                .email(userDTO.email())
                .messages(messages)
                .suggestions(suggestion)
                .build();
    }

    public static UserDTO userEntityToUserDTO(User user) {
        var messages = user.getMessages().stream()
                .map(MessageMapper::MessageEntitytoMessageDTO)
                .collect(Collectors.toList());

        var suggestions = user.getSuggestions().stream()
                .map(SuggestionMapper::SuggestionEntityToSuggestionDTO)
                .collect(Collectors.toList());

        return new UserDTO(
                user.getUserId(),
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail(),
                messages,
                suggestions
        );
    }

    public static User userToSaveDTOtoUserEntity(UserToSaveDTO userToSaveDTO) {
        return User.builder()
                .userId(userToSaveDTO.id())
                .firstname(userToSaveDTO.firstname())
                .lastname(userToSaveDTO.lastname())
                .username(userToSaveDTO.username())
                .email(userToSaveDTO.email())
                .build();
    }

}
