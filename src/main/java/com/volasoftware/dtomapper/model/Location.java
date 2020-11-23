package com.volasoftware.dtomapper.model;

import com.volasoftware.dtomapper.enums.Country;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String city;

    private String address;

    public Location() {
    }

    public Location(Country country, String city, String address) {
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
