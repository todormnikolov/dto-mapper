package com.volasoftware.dtomapper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private LocalDateTime lastLogin;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Location location;

    @ManyToMany()
    private Set<User> followers;

    public User(String firstName, String lastName, LocalDate birthday, LocalDateTime lastLogin, String email, String password, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.lastLogin = lastLogin;
        this.email = email;
        this.location = location;
        setPassword(password);
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}

