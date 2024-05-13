package com.example.BlogApplication.Controller;

import com.example.BlogApplication.Payloads.ApiResponse;
import com.example.BlogApplication.Payloads.UserDTO;
import com.example.BlogApplication.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //Post
    @PostMapping("/newUser")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdDTO = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }

    //Put
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable("id") Integer userId) {
        UserDTO updatedUser = this.userService.updateUser(userDTO, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Get
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer userId) {
        UserDTO userDTO = this.userService.getUserById(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> userDTOList = this.userService.getAllUsers();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Integer userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully.", true), HttpStatus.OK);
    }
}
