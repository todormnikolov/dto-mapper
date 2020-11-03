package com.volasoftware.dtomapper.repository;

import com.volasoftware.dtomapper.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Location, Long> {
}
