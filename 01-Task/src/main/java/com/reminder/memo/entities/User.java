package com.reminder.memo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String email;
    private String names;
    private String lastnames;
    private String password;
    private String repPassword;
    private Integer age;
    private String photo;
    private Boolean enabled;
    private String role;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messages;

    @ManyToMany
    @JoinTable(name = "user_matches",
            joinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "match_id",
                    referencedColumnName = "matchId"))
    private List<Match> matches;

}
