package com.uraraka.socialz.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email"})
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String photo;

    private String role;

    private Boolean enabled;

    @Temporal(value = TemporalType.DATE)
    private LocalDate birthdate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Message> messages;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Suggestion> suggestions;

    @ManyToMany(mappedBy = "participants")
    private Set<Match> matches;
}
