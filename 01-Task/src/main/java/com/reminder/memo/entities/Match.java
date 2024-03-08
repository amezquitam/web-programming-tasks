package com.reminder.memo.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

@Entity
@Table(name = "matchs")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    private String creator;

    private String sport;

    private String city;

    private String province;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timeStart;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timeEnd;

    private Integer nParticipants;

    private Integer nSuplents;
    
    private String comments;

    @ManyToMany(mappedBy = "matches")
    private List<User> userMatches;

}
