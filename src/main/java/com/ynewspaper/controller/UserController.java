package com.ynewspaper.controller;

import com.ynewspaper.entity.*;
import com.ynewspaper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(
            @RequestParam String name,
            @RequestParam String email) {

        User user = userService.createUser(name, email);
        return ResponseEntity.ok(user);
    }
}