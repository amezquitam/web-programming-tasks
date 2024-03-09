package com.reminder.memo.repository;

import com.reminder.memo.AbstractIntegrationDBTest;
import com.reminder.memo.entities.Match;
import com.reminder.memo.entities.Message;
import com.reminder.memo.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchRepositoryTest extends AbstractIntegrationDBTest {

    @BeforeEach
    void setUp() {
    }
    @Autowired
    UserRepository userRepository;
    @Autowired
    MatchRepository matchRepository;

    @Test
    void giveAMatch(){
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


        Match match = Match.builder()
                .creator("awdopd")
                .city("hokkaido")
                .sport("natation")
                .comments("ndoiuw")
                .province("mana")
                .date(LocalDate.of(2024,12,12))
                .nParticipants(2)
                .timeStart(LocalTime.of(12,12))
                .timeEnd(LocalTime.of(15,15))
                .nSuplents(3)
                .userMatches(List.of(user1,user2))
                .build();
        match = matchRepository.save(match);

        Assertions.assertThat(match.getMatchId()).isNotNull();
        Assertions.assertThat(match.getUserMatches()).hasSize(2);
    }



}