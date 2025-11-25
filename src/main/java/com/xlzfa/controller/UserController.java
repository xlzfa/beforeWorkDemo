package com.xlzfa.controller;

import com.xlzfa.common.ResponseResult;
import com.xlzfa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
//@GetMapping(value = "/{id}", produces = "application/json")
    public ResponseResult getById(@PathVariable("id") Long id) {

        return userService.getById(id);

    }

}
