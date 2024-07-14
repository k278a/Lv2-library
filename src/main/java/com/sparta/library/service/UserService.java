package com.sparta.library.service;

import com.sparta.library.dto.UserRequestDto;
import com.sparta.library.dto.UserResponseDto;
import com.sparta.library.entity.User;
import com.sparta.library.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto);
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser);
    }
}
