package com.example.blog.service.impl;

import com.example.blog.dto.TagDto;
import com.example.blog.entity.Tag;
import com.example.blog.repository.TagRepository;
import com.example.blog.service.interf.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Page<TagDto> findAllTags(String name, Pageable pageable) {
        Page<Tag> page = tagRepository.findAllTags(name, pageable);
        return page.map(TagDto::new);
    }

    @Override
    public TagDto findTagById(Long id) {
        Tag find = tagRepository.findById(id).orElseThrow();
        return new TagDto(find);
    }

    @Override
    public TagDto saveTag(TagDto dto) {

        Tag add = new Tag();
        add.setName(dto.getName());
        add.setImage(dto.getImage());
        add.setCategory(dto.getCategory());

        return new TagDto(tagRepository.saveAndFlush(add));
    }

    @Override
    public TagDto updateTag(TagDto dto) {

        Tag edit = tagRepository.findById(dto.getId()).orElseThrow();
        edit.setId(edit.getId());
        edit.setName(dto.getName());
        edit.setImage(dto.getImage());
        edit.setCategory(dto.getCategory());

        return new TagDto(tagRepository.save(edit));
    }

    @Override
    public void deleteTag(Long id) {
        this.tagRepository.deleteById(id);
    }
}
