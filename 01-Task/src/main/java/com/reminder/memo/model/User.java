package com.reminder.memo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
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
    @JoinTable(name = "user_matches", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "userId") }, inverseJoinColumns = @JoinColumn(name = "match_id", referencedColumnName = "matchId"))
    private List<Match> matches;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepPassword() {
        return repPassword;
    }

    public void setRepPassword(String repPassword) {
        this.repPassword = repPassword;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createAt) {
        this.createdAt = createAt;
    }
}
