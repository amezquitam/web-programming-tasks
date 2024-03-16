package com.uraraka.socialz.dto.suggestion;

import com.uraraka.socialz.entities.Suggestion;

public class SuggestionMapper {
    public static Suggestion SuggestionDTOtoSuggestionEntity(SuggestionDTO suggestionDTO) {
        return Suggestion.builder()
                .suggestionId(suggestionDTO.id())
                .description(suggestionDTO.description())
                .build();
    }

    public static SuggestionDTO SuggestionEntityToSuggestionDTO(Suggestion suggestion) {
        return new SuggestionDTO(suggestion.getSuggestionId(), suggestion.getDescription());
    }
}
