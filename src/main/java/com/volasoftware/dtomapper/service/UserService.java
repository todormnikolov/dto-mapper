package com.volasoftware.dtomapper.service;

import com.volasoftware.dtomapper.dto.UserDto;
import com.volasoftware.dtomapper.model.User;
import com.volasoftware.dtomapper.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.volasoftware.dtomapper.mapper.MapperHelper.mapToDto;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        List<User> allUsers = userRepository.findAll();

        return allUsers.stream()
                .map(user -> mapToDto(user))
                .collect(Collectors.toList());
    }

    public UserDto findUserByEmail(String email) {
        return mapToDto(userRepository.findByEmail(email));
    }
}
