package com.uraraka.socialz.repositories;

import com.uraraka.socialz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
