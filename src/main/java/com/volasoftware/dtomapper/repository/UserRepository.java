package com.volasoftware.dtomapper.repository;

import com.volasoftware.dtomapper.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByEmail(String email);
}
