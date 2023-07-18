package com.example.blog.controller;

import com.example.blog.dto.PostDto;
import com.example.blog.entity.User;
import com.example.blog.service.interf.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/save")
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto dto) {
        PostDto add = postService.savePost(dto);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto dto) {
        PostDto edit = postService.updatePost(dto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostByUser(@PathVariable User user) {
        this.postService.deletePostByUser(user);
    }
}
