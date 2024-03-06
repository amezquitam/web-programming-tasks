package com.reminder.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reminder.memo.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByUsername(String username);

    @Query("SELECT u FROM Users u WHERE u.name = ?1 AND u.lastname = ?2")
    public List<User> findByNameAndLastname(String name, String lastname);
}
