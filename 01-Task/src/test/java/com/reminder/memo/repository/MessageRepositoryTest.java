package com.reminder.memo.repository;

import com.reminder.memo.AbstractIntegrationDBTest;
import com.reminder.memo.entities.Message;
import com.reminder.memo.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MessageRepositoryTest extends AbstractIntegrationDBTest {
    MessageRepository messageRepository;
    UserRepository userRepository;

    @Autowired
    public MessageRepositoryTest(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUp() {
        messageRepository.deleteAll();
    }

    @Test
    void givenAnMessage_WhenInsert_ThenMessageIdIsNotNull() {
        User user1 = User.builder()
                .names("pepe")
                .lastnames("duran")
                .password("1234")
                .build();
        User user2 = User.builder()
                .names("maya")
                .lastnames("terraplanista")
                .password("1234")
                .build();

        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);

        Message message = Message.builder()
                .destinatary("maya")
                .creator("pepe")
                .content("aña")
                .user(user1)
                .build();

        Message messageSaved = messageRepository.save(message);

        assertThat(messageSaved.getMessageId()).isNotNull();
    }
}