package com.reminder.memo.repository;

import com.reminder.memo.AbstractIntegrationDBTest;
import com.reminder.memo.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest extends AbstractIntegrationDBTest {
    UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void givenAnUser_whenSave_thenUserWithId() {

        User user = User.builder()
                .names("Julian")
                .lastnames("Pizarro")
                .username("julianpizarro")
                .password("123")
                .build();

        User userSaved = userRepository.save(user);

        assertThat(userSaved.getUserId()).isNotNull();

    }
    @Test
    @DisplayName("Dado un conjunto de usuarios, al buscarlos todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllUsers() {
        //GIVEN
        User user = User.builder()
                .names("Julian")
                .lastnames("Pizarro")
                .username("julianpizarro")
                .password("123")
                .build();
        userRepository.save(user);

        User user2 = User.builder()
                .names("Jose")
                .lastnames("Pertuz")
                .username("josepertuz")
                .password("123")
                .build();
        userRepository.save(user2);
        userRepository.flush();

        List<User> users = userRepository.findAll();

        assertThat(users).hasSize(2);
    }
    @Test
    void givenUsers_whenFindByNameAndLastname_thenGetUserList(){
        User user = User.builder()
                .names("Julian")
                .lastnames("Pizarro")
                .username("julianpizarro")
                .password("123")
                .build();
        userRepository.save(user);
        User user2 = User.builder()
                .names("Jose")
                .lastnames("Pertuz")
                .username("josepertuz")
                .password("123")
                .build();
        userRepository.save(user);

        List<User> users = userRepository.findByNameAndLastname("Julian", "Pizarro");

        assertThat(users).isNotEmpty();
        assertThat(users).first().hasFieldOrPropertyWithValue("names","Julian");
    }

}