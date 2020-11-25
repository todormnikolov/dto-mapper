package com.volasoftware.dtomapper.model;

import com.volasoftware.dtomapper.enums.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String city;

    private String address;

    public Location(Country country, String city, String address) {
        this.country = country;
        this.city = city;
        this.address = address;
    }
}
