package com.uraraka.socialz.dto.message;

import com.uraraka.socialz.dto.user.UserDTO;

public record MessageDTO(
        Long id,
        String content,
        String receiver
) {
}
