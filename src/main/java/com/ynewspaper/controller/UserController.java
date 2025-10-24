package com.ynewspaper.controller;

import com.ynewspaper.dto.UserDTO;
import com.ynewspaper.entity.User;
import com.ynewspaper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO) {
       return userService.createUser(userDTO);
    }
    
        
    

   /* @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserWithArticles(id);
        return ResponseEntity.ok(userDTO);
    } */
}