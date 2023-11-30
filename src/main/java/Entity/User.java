package Entity;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "user")
public class User {

    @jakarta.persistence.Id
    @Column(name = "id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", length = 15,nullable = false,unique = true)
    private String login;

    @Column(name = "password")
    private String password;


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
