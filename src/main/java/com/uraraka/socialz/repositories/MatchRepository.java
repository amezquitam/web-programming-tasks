package com.uraraka.socialz.repositories;

import com.uraraka.socialz.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
