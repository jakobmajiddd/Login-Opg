package com.aflevering.loginopgave.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
