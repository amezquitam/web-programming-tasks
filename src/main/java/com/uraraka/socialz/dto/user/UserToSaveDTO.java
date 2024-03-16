package com.uraraka.socialz.dto.user;

import com.uraraka.socialz.dto.message.MessageDTO;

import java.util.List;

public record UserToSaveDTO(
        Long id,
        String firstname,
        String lastname,
        List<MessageDTO> messages,
        String email,
        String photo
) {
}
