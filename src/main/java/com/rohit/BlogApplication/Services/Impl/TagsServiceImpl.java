package com.rohit.BlogApplication.Services.Impl;

import com.rohit.BlogApplication.Entity.Tags;
import com.rohit.BlogApplication.Exceptions.ResourceNotFoundException;
import com.rohit.BlogApplication.Payloads.TagsDTO;
import com.rohit.BlogApplication.Repository.TagsRepo;
import com.rohit.BlogApplication.Services.TagsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsRepo tagsRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TagsDTO createTag(TagsDTO tagsDTO) {
        Tags tag = this.modelMapper.map(tagsDTO, Tags.class);
        Tags savedTag = this.tagsRepo.save(tag);
        return this.modelMapper.map(savedTag, TagsDTO.class);
    }

    @Override
    public TagsDTO updateTag(TagsDTO tagsDTO, Integer tagId) {
        Tags tag = this.tagsRepo.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Tag", "Id", tagId));

        tag.setTagName(tagsDTO.getTagName());
        tag.setTagDescription(tagsDTO.getTagDescription());

        Tags updatedTag = this.tagsRepo.save(tag);
        return this.modelMapper.map(updatedTag, TagsDTO.class);
    }

    @Override
    public TagsDTO getTagById(Integer tagId) {
        Tags tag = this.tagsRepo.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Tag", "Id", tagId));
        return this.modelMapper.map(tag, TagsDTO.class);
    }

    @Override
    public List<TagsDTO> getAllTags() {
        List<Tags> allTags = this.tagsRepo.findAll();
        return allTags.stream().map(tag -> modelMapper.map(tag, TagsDTO.class)).toList();
    }

    @Override
    public void deleteTag(Integer tagId) {
        Tags tag = this.tagsRepo.findById(tagId).orElseThrow(() -> new ResourceNotFoundException("Tag", "Id", tagId));
        this.tagsRepo.delete(tag);
    }
}
