package com.medvoda.medenychivoda.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    public enum userRole {
        ROLE_ADMIN,
        ROLE_EMPLOYEE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private userRole role;

    @Column(name = "login",nullable = false)
    private String login;

    @ManyToOne
    @JoinColumn(name = "login", referencedColumnName = "login", insertable = false, updatable = false)
    private User user;

    public userRole getRole() {
        return role;
    }

    public void setRole(userRole role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
