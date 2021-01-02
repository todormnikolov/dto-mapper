package com.volasoftware.dtomapper.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private LocalDateTime lastLogin;

    private String email;

    private String password;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Location location;

    @ManyToMany()
    private Set<User> followers;

    public User() { }

    public User(String firstName, String lastName, LocalDate birthday, LocalDateTime lastLogin, String email, String password, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.lastLogin = lastLogin;
        this.email = email;
        this.location = location;
        setPassword(password);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public Location getAddress() {
        return location;
    }

    public void setAddress(Location location) {
        this.location = location;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }
}
