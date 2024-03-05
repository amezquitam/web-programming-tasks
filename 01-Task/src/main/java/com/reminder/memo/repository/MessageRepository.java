package com.reminder.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reminder.memo.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    
}
