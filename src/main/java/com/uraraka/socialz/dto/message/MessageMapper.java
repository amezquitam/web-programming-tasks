package com.uraraka.socialz.dto.message;

import com.uraraka.socialz.entities.Message;

public class MessageMapper {
    public static Message MessageDTOtoMessageEntity(MessageDTO messageDTO) {
        return Message.builder()
                .id(messageDTO.id())
                .content(messageDTO.content())
                .receiver(messageDTO.receiver())
                .build();
    }

    public static MessageDTO MessageEntitytoMessageDTO(Message message) {
        return new MessageDTO(message.getId(), message.getContent(), message.getReceiver());
    }
}
