package com.uraraka.socialz.dto.suggestion;

import com.uraraka.socialz.dto.message.MessageMapper;
import com.uraraka.socialz.entities.Suggestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SuggestionMapper {
    SuggestionMapper INSTANCE = Mappers.getMapper(SuggestionMapper.class);

    @Mapping(source = "suggestionDTO.id", target = "suggestionId")
    Suggestion SuggestionDTOtoSuggestionEntity(SuggestionDTO suggestionDTO);

    @Mapping(source = "suggestion.suggestionId", target = "id")
    SuggestionDTO SuggestionEntityToSuggestionDTO(Suggestion suggestion);
}
