package com.example.blog.service.impl;

import com.example.blog.dto.CommentDto;
import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.repository.CommentRepository;
import com.example.blog.service.interf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Page<CommentDto> findCommentsByPost(Post post, Pageable pageable) {
        Page<Comment> page = commentRepository.findByPost(post, pageable);
        return page.map(CommentDto::new);
    }

    @Override
    public CommentDto findCommentById(Long id) {
      Comment find = commentRepository.findById(id).orElseThrow();
        return new CommentDto(find);
    }
}
