package com.example.blog.service.impl;

import com.example.blog.dto.CommentDto;
import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

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

    @Override
    public CommentDto saveComment(CommentDto dto) {
        User user = userRepository.findById(dto.getUser().getId()).orElseThrow();
        Post post = postRepository.findById(dto.getPost().getId()).orElseThrow();;
        Comment add = new Comment();
        add.setBody(dto.getBody());
        add.setImage(dto.getImage());
        add.setPost(post);
        add.setUser(user);
        return new CommentDto(commentRepository.saveAndFlush(add));
    }

    @Override
    public CommentDto updateComment(CommentDto dto) {
        Comment edit = commentRepository.findById(dto.getId()).orElseThrow();
        edit.setBody(dto.getBody());
        edit.setImage(dto.getImage());
        return new CommentDto(commentRepository.save(edit));
    }

    @Override
    public void deleteComment(Long id) {
        this.commentRepository.deleteById(id);
    }
}
