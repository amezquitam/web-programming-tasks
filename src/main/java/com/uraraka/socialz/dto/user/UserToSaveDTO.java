package com.uraraka.socialz.dto.user;

public record UserToSaveDTO(
        Long id,
        String firstname,
        String lastname,
        String username,
        String email
) {
}
