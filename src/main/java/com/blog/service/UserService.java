package com.blog.service;

import com.blog.domain.User;
import com.blog.dto.UserDto;
import com.blog.exceptions.UserNotFoundException;
import com.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    public User updateUser(UserDto userDto, long userId) throws UserNotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(String.format("User with id %s not found", userId));
        } else {
            User user = userRepository.save(modelMapper.map(userDto, User.class));
            user.setUserId(userId);
            return userRepository.save(user);
        }
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public User findByMail(String mail) throws UserNotFoundException {
        return userRepository.findByMail(mail)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with email %s not found", mail)));
    }

    public User getUser(final Long userId) throws UserNotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User with id %s not found");
        } else {
            return userRepository.findById(userId).get();
        }
    }

    public void deleteUserById(final Long userId) throws UserNotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User with id %s not found");
        } else {
            userRepository.deleteById(userId);
        }
    }
}
