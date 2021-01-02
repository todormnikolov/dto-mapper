package com.volasoftware.dtomapper.mapper;

import com.volasoftware.dtomapper.dto.UserDto;
import com.volasoftware.dtomapper.model.User;
import com.volasoftware.dtomapper.util.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = LocationMapper.class, imports = {DateUtil.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mappings({
            @Mapping(target = "name", source = "user", qualifiedByName = "concatUserName"),
            @Mapping(target = "age", expression = "java(DateUtil.calculateAge(user.getBirthday()))"),
            @Mapping(target = "lastLogin", dateFormat = DateUtil.DATETIME_PATTERN),
            @Mapping(target = "address", source = "location")
    })
    UserDto toDto(User user);

    @Named("concatUserName")
    default String concatName(User user) {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
}
