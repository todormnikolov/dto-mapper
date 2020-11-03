package com.volasoftware.dtomapper.controller;

import com.volasoftware.dtomapper.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.volasoftware.dtomapper.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/emails/{email}", produces = "application/json")
    public UserDto getUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
}
