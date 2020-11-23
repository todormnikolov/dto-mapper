package com.volasoftware.dtomapper.mapper;

import com.volasoftware.dtomapper.dto.LocationDto;
import com.volasoftware.dtomapper.dto.UserDto;
import com.volasoftware.dtomapper.model.Location;
import com.volasoftware.dtomapper.model.User;

import java.util.stream.Collectors;

public class MapperHelper {

    public static UserDto mapToDto(User user) {
        if(user == null) {
            throw new RuntimeException();
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getFirstName() + " " + user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setAddress(mapToDto(user.getAddress()));
            userDto.setFollowers(
                    user.getFollowers().stream()
                            .map(MapperHelper::mapToDto)
                            .collect(Collectors.toList()));

        return userDto;
    }

    public static LocationDto mapToDto(Location location) {
        if(location == null) {
            throw new RuntimeException();
        }

        LocationDto locationDto = new LocationDto();
//        locationDto.setId(location.getId());
        locationDto.setCountry(location.getCountry().getName());
        locationDto.setCity(location.getCity());
        locationDto.setAddress(location.getAddress());

        return locationDto;
    }
}
