package com.reminder.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reminder.memo.model.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
    
}
