package com.irtiza.lanes.controllers;

import com.irtiza.lanes.dtos.CreateUserDto;
import com.irtiza.lanes.dtos.UserResponseDto;
import com.irtiza.lanes.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid CreateUserDto userDto) {
        return new ResponseEntity<>(userService.create(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<UserResponseDto>> findAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponseDto> findUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<UserResponseDto> updateUser(@PathVariable String id, @RequestBody @Valid CreateUserDto userDto) {
        return ResponseEntity.ok(userService.update(id, userDto));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity
                .accepted()
                .body("User deleted successfully");
    }
}
