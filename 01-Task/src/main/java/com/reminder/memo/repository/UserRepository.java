package com.reminder.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reminder.memo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
