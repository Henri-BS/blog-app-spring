package com.example.blog.service.interf;

import com.example.blog.dto.PostTagDto;
import com.example.blog.entity.Post;
import com.example.blog.entity.Tag;

import java.util.List;

public interface PostTagService {
    List<PostTagDto> findAllPostTags(String post, String tag);

    PostTagDto savePostTag(PostTagDto dto);

    void deletePostTag(Long id);
}
