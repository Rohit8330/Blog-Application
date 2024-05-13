package com.example.BlogApplication.Payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TagsDTO {

    private Integer tagId;

    @NotEmpty
    @Size(min = 2, max = 20, message = "name at least have 2 chars & at max 20.")
    private String tagName;

    @NotEmpty
    private String tagDescription;
}
