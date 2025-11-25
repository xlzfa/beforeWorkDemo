package com.xlzfa.controller;

import com.xlzfa.common.ResponseResult;
import com.xlzfa.domain.dto.UserDto;
import com.xlzfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseResult getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @PostMapping("/login")
    public ResponseResult login(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

}
