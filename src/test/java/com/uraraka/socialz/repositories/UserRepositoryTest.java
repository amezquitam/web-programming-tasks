package com.uraraka.socialz.repositories;

import com.uraraka.socialz.AbstractIntegrationDBTest;
import com.uraraka.socialz.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRepositoryTest extends AbstractIntegrationDBTest {
    UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    public void whenInsertAUser_thenUserIdIsNotNull() {
        User user = User.builder()
                .username("Mario12")
                .firstname("Mario")
                .lastname("Méndez")
                .build();

        User userSaved = userRepository.save(user);

        Assertions.assertThat(userSaved.getUserId()).isNotNull();
    }
}
