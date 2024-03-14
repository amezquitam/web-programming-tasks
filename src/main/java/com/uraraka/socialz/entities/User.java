package com.uraraka.socialz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
