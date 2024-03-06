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

@Entity
@Table(name = "matchs")
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

    
    public Match() {
    }


    public Long getMatchId() {
        return matchId;
    }


    public void setMatchId(Long id) {
        this.matchId = id;
    }


    public String getCreator() {
        return creator;
    }


    public void setCreator(String creator) {
        this.creator = creator;
    }


    public String getSport() {
        return sport;
    }


    public void setSport(String sport) {
        this.sport = sport;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getProvince() {
        return province;
    }


    public void setProvince(String province) {
        this.province = province;
    }


    public LocalDateTime getDate() {
        return date;
    }


    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public LocalDateTime getTimeStart() {
        return timeStart;
    }


    public void setTimeStart(LocalDateTime hourStart) {
        this.timeStart = hourStart;
    }


    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }


    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }


    public Integer getnParticipants() {
        return nParticipants;
    }


    public void setnParticipants(Integer nParticipants) {
        this.nParticipants = nParticipants;
    }


    public Integer getnSuplents() {
        return nSuplents;
    }


    public void setnSuplents(Integer nSuplents) {
        this.nSuplents = nSuplents;
    }


    public String getComments() {
        return comments;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }

    

}
