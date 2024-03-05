package com.reminder.memo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private String creator;

    private String destinatary;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    private String content;

    @ManyToOne()
    @JoinColumn()
    private User user;

    public Message() {
    }
    
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long id) {
        this.messageId = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDestinatary() {
        return destinatary;
    }

    public void setDestinatary(String destinatary) {
        this.destinatary = destinatary;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createAt) {
        this.createdAt = createAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
