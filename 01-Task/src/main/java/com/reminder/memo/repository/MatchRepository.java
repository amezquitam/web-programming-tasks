package com.reminder.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reminder.memo.model.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
    
}
