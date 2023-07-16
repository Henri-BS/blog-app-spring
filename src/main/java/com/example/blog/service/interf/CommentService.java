package com.example.blog.service.interf;


import com.example.blog.dto.CommentDto;
import com.example.blog.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {


    Page<CommentDto> findCommentsByPost(Post post, Pageable pageable);

    CommentDto findCommentById(Long id);

    CommentDto saveComment(CommentDto dto);

    CommentDto updateComment(CommentDto dto);

    void deleteComment(Long id);
}
