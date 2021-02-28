package com.volasoftware.dtomapper.mapper;

import com.volasoftware.dtomapper.dto.UserDto;
import com.volasoftware.dtomapper.model.User;
import com.volasoftware.dtomapper.util.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = LocationMapper.class, imports = {DateUtil.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(target = "name", source = "user", qualifiedByName = "concatUserName")
    @Mapping(target = "age", expression = "java(DateUtil.calculateAge(user.getBirthday()))")
    @Mapping(target = "lastLogin", dateFormat = DateUtil.DATETIME_PATTERN)
    @Mapping(target = "address", source = "location")
    @Mapping(target = "followers", source = "followers", qualifiedByName = "mapFollowers")
    UserDto toDto(User user);

    @Mapping(target = "name", source = "follower", qualifiedByName = "concatUserName")
    @Mapping(target = "age", expression = "java(DateUtil.calculateAge(follower.getBirthday()))")
    @Mapping(target = "lastLogin", dateFormat = DateUtil.DATETIME_PATTERN)
    @Mapping(target = "address", source = "location")
    @Mapping(target = "followers", ignore = true)
    UserDto addFollowerToUserDto(User follower);

    @Named("concatUserName")
    default String concatName(User user) {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }

    @Named("mapFollowers")
    default List<UserDto> mapUsersToFollowers(Set<User> followers) {
        return followers.stream()
                .map(this::addFollowerToUserDto)
                .collect(Collectors.toList());
    }
}
