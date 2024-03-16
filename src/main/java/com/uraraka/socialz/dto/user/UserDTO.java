package com.uraraka.socialz.dto.user;

import com.uraraka.socialz.dto.message.MessageDTO;
import com.uraraka.socialz.dto.suggestion.SuggestionDTO;

import java.util.Collections;
import java.util.List;

public record UserDTO(
    Long id,
    String firstname,
    String lastname,
    String username,
    String email,
    List<MessageDTO> messages,
    List<SuggestionDTO> suggestions
) {
    @Override
    public List<MessageDTO> messages() {
        return Collections.unmodifiableList(messages);
    }

    @Override
    public List<SuggestionDTO> suggestions() {
        return Collections.unmodifiableList(suggestions);
    }
}
