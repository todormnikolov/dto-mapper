package com.volasoftware.dtomapper.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {

    private long id;
    private String name;
    private String email;
    private LocationDto address;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserDto> followers;
}
