package com.rohit.BlogApplication.Controller;

import com.rohit.BlogApplication.Payloads.ApiResponse;
import com.rohit.BlogApplication.Payloads.TagsDTO;
import com.rohit.BlogApplication.Services.TagsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagsController {
    @Autowired
    private TagsService tagsService;

    @PostMapping("/create")
    public ResponseEntity<TagsDTO> createTags(@Valid @RequestBody TagsDTO tagsDTO){
        TagsDTO tag = this.tagsService.createTag(tagsDTO);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TagsDTO> updateTags(@Valid @RequestBody TagsDTO tagsDTO, @PathVariable("id") Integer tagId){
        TagsDTO tag = this.tagsService.updateTag(tagsDTO, tagId);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TagsDTO> getTag(@PathVariable("id") Integer tagId){
        TagsDTO tagsDTO = this.tagsService.getTagById(tagId);
        return new ResponseEntity<>(tagsDTO, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TagsDTO>> getAllTag(){
        List<TagsDTO> tags = this.tagsService.getAllTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteTag(@PathVariable("id") Integer tagId){
        this.tagsService.deleteTag(tagId);
        return new ResponseEntity<>(new ApiResponse("Tag deleted successfully.", true), HttpStatus.OK);
    }
}
