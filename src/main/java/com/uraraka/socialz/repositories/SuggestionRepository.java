package com.uraraka.socialz.repositories;

import com.uraraka.socialz.entities.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
}
