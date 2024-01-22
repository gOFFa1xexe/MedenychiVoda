package com.medvoda.medenychivoda.Entity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", length = 15,nullable = false,unique = true)
    private String login;

    @Column(name = "password", length = 68, nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Roles> roles;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getId() {
        return id;
    }
}
