package com.irtiza.lanes.services;

import com.irtiza.lanes.dtos.CreateUserDto;
import com.irtiza.lanes.dtos.UserResponseDto;
import com.irtiza.lanes.mappers.UserMapper;
import com.irtiza.lanes.models.User;
import com.irtiza.lanes.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDto create(CreateUserDto createUserDto) {
        User newUser = User.builder()
                .name(createUserDto.getName())
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .avatar(createUserDto.getAvatar())
                .build();

        User savedUser = userRepository.save(newUser);
        return userMapper.toDto(savedUser);
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public UserResponseDto findById(String id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public UserResponseDto update(String id, CreateUserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        // updating user properties
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAvatar(userDto.getAvatar());

        User updatedUser = userRepository.save(user);

        return userMapper.toDto(updatedUser);
    }

    public void delete(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
