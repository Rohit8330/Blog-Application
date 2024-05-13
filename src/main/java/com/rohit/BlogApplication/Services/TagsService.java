package com.example.BlogApplication.Services;

import com.example.BlogApplication.Payloads.TagsDTO;
import com.example.BlogApplication.Payloads.UserDTO;

import java.util.List;

public interface TagsService {
    TagsDTO createTag(TagsDTO tagsDTO);
    TagsDTO updateTag(TagsDTO tagsDTO, Integer tagId);
    TagsDTO getTagById(Integer tadId);
    List<TagsDTO> getAllTags();
    void deleteTag(Integer tagId);
}
