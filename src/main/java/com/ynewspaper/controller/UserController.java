package com.ynewspaper.controller;

import com.ynewspaper.dto.UserDTO;
import com.ynewspaper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(
            @RequestParam String name,
            @RequestParam String email) {

        UserDTO userDTO = userService.createUser(name, email);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserWithArticles(id);
        return ResponseEntity.ok(userDTO);
    }
}