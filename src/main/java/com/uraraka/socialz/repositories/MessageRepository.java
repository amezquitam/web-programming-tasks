package com.uraraka.socialz.repositories;

import com.uraraka.socialz.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
