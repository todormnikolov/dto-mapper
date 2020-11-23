package com.volasoftware.dtomapper.mapper;

import com.volasoftware.dtomapper.dto.UserDto;
import com.volasoftware.dtomapper.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(uses = LocationMapper.class)
public interface UserMapper {

    @Mappings({
            @Mapping(target = "name", source = "user", qualifiedByName = "concatName")
    })
    UserDto toDto(User user);

    @Named("concatName")
    default String concatUserName(User user) {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}
