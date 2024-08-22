package com.blog.controller;

import com.blog.domain.User;
import com.blog.dto.UserDto;
import com.blog.exceptions.UserNotFoundException;
import com.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(modelMapper.map(userService.saveUser(userDto), UserDto.class));
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId) throws UserNotFoundException {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<UserDto> findAll() {
        List<UserDto> users = userService.getAllUsers();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long userId) throws UserNotFoundException {
        return ResponseEntity.ok(modelMapper.map(userService.getUser(userId), UserDto.class));
    }

    @PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable long userId) throws UserNotFoundException {
        return ResponseEntity.ok(modelMapper.map(userService.updateUser(userDto, userId), UserDto.class));
    }

    @GetMapping("/findByMail")
    public ResponseEntity<UserDto> findByMail(@RequestParam String mail) throws UserNotFoundException {
        User user = userService.findByMail(mail);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok(userDto);
    }
}
