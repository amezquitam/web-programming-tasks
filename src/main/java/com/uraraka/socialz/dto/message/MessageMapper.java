package com.uraraka.socialz.dto.message;

import com.uraraka.socialz.entities.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    Message MessageDTOtoMessageEntity(MessageDTO messageDTO);

    MessageDTO MessageEntitytoMessageDTO(Message message);
}
