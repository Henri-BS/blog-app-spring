package com.example.blog.controller;

import com.example.blog.dto.PostDto;
import com.example.blog.service.interf.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findPostById(@PathVariable Long id) {
        PostDto find = postService.findById(id);
        return ResponseEntity.ok(find);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<PostDto>> findAllPosts(@RequestParam(defaultValue = "") String title, Pageable pageable) {
        Page<PostDto> page = postService.findAllPosts(title, pageable);
        return ResponseEntity.ok(page);
    }
}
