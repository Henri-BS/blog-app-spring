package com.example.blog.service.interf;


import com.example.blog.dto.PostDto;
import com.example.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto findById(Long id);

    Page<PostDto> findAllPosts(String title, Pageable pageable);

    PostDto savePost(PostDto dto);

    PostDto updatePost(PostDto dto);

    void deletePostByUser(User user);
}
