package com.ynewspaper.service;

import com.ynewspaper.dto.UserDTO;
import com.ynewspaper.entity.User;
import com.ynewspaper.mapper.UserMapper;
import com.ynewspaper.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(UserDTO dto) {
        User user = userMapper.toEntity(dto);
        return userRepository.save(user); 
    }

    @Override
    public UserDTO getUserWithArticles(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserWithArticles'");
    }

    /*@Override
    public UserDTO getUserWithArticles(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }*/
}
