package com.volasoftware.dtomapper.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class UserDto {

    private long id;
    private String name;
    private String email;
    private LocationDto address;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserDto> followers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocationDto getAddress() {
        return address;
    }

    public void setAddress(LocationDto address) {
        this.address = address;
    }

    public List<UserDto> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDto> followers) {
        this.followers = followers;
    }
}
