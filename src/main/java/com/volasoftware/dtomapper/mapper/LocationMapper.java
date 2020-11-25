package com.volasoftware.dtomapper.mapper;

import com.volasoftware.dtomapper.dto.LocationDto;
import com.volasoftware.dtomapper.enums.Country;
import com.volasoftware.dtomapper.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper
public interface LocationMapper {

    @Mappings({
        @Mapping(target= "country", source = "location.country", qualifiedByName = "getCountry")
    })
    LocationDto toDto(Location location);

    @Named("getCountry")
    default String getCountryName(Country country) {
        return country.getName();
    }
}
