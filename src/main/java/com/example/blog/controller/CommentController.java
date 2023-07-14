package com.example.blog.controller;

import com.example.blog.dto.CommentDto;
import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.service.interf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list/{post}")
    public ResponseEntity<Page<CommentDto>> findCommentsByPost(@PathVariable Post post, Pageable pageable) {
        Page<CommentDto> page = commentService.findCommentsByPost(post, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> findCommentById(@PathVariable Long id){
        CommentDto find = commentService.findCommentById(id);
        return ResponseEntity.ok(find);
    }
}