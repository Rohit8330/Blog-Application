package com.rohit.BlogApplication.Payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class PostDTO {

    @NotEmpty
    @Size(min = 2, max = 20, message = "name at least have 2 chars & at max 20.")
    private String title;

    @NotEmpty
    @Size(min = 10, max = 5000)
    private String content;

    private String imageName;

    private Date publishedDate;

    private TagsDTO tags;

    private UserDTO user;

}
