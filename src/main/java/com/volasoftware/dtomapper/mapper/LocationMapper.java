package com.volasoftware.dtomapper.mapper;

import com.volasoftware.dtomapper.dto.LocationDto;
import com.volasoftware.dtomapper.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface LocationMapper {

    @Mapping(target= "country", source= "country.name")
    LocationDto toDto(Location location);
}
