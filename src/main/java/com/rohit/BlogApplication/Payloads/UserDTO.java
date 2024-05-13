package com.example.BlogApplication.Payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {

    private int id;

    @NotEmpty
    @Size(min = 2, max = 20, message = "name at-least have 2 chars.")
    private String name;

    @Email(message = "Invalid Email!")
    private String email;

    @NotEmpty
    @Size(min = 4, max = 15, message = "password must be minimum of 4 and max of 15.")
    private String password;

    @NotEmpty
    private String about;
}
