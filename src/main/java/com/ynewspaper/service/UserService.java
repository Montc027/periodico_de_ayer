package com.ynewspaper.service;

import com.ynewspaper.entity.User;
import com.ynewspaper.dto.UserDTO;

public interface UserService {
    User createUser(UserDTO dto);
    UserDTO getUserWithArticles(Long id);
}

/*
package com.ynewspaper.service;

import com.ynewspaper.dto.UserDTO;
import com.ynewspaper.entity.User;
import com.ynewspaper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        return userRepository.save(user);
    }
} */