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

@Mapper(uses = LocationMapper.class, imports = {Period.class, LocalDate.class})
public interface UserMapper {

    @Mappings({
            @Mapping(target = "name", source = "user", qualifiedByName = "concatName"),
            @Mapping(target = "age", expression = "java(Period.between(user.getBirthday(), LocalDate.now()).getYears())"),
            @Mapping(target = "lastLogin", dateFormat = DateUtil.DATETIME_PATTERN)
    })
    UserDto toDto(User user);

    @Named("concatName")
    default String concatUserName(User user) {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}
