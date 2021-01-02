package com.volasoftware.dtomapper.mapper;

import com.volasoftware.dtomapper.dto.UserDto;
import com.volasoftware.dtomapper.model.User;
import com.volasoftware.dtomapper.util.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.Period;

@Mapper(uses = LocationMapper.class, imports = {DateUtil.class})
public interface UserMapper {

    @Mappings({
            @Mapping(target = "name", source = "user", qualifiedByName = "concatName"),
            @Mapping(target = "age", expression = "java(DateUtil.calculateAge(user.getBirthday()))"),
            @Mapping(target = "lastLogin", dateFormat = DateUtil.DATETIME_PATTERN)
    })
    UserDto toDto(User user);

    @Named("concatName")
    default String concatUserName(User user) {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}
