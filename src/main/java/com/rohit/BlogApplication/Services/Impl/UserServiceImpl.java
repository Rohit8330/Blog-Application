package com.example.BlogApplication.Services.Impl;

import com.example.BlogApplication.Entity.User;
import com.example.BlogApplication.Exceptions.ResourceNotFoundException;
import com.example.BlogApplication.Payloads.UserDTO;
import com.example.BlogApplication.Repository.UserRepo;
import com.example.BlogApplication.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = dtoToUser(userDTO);
        User savedUser = this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = userRepo.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User", "id", userId));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());

        User updatedUser = userRepo.save(user);

        return userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User", "id", userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        return allUsers.stream().map(this::userToDto).toList();
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);
    }

    public User dtoToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO userToDto(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }
}
