package com.example.blog.service.interf;

import com.example.blog.dto.TagDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {

    Page<TagDto> findAllTags(String title, Pageable pageable);

    TagDto findTagById(Long id);

    TagDto saveTag(TagDto dto);

    TagDto updateTag(TagDto dto);

    void deleteTag(Long id);

}
