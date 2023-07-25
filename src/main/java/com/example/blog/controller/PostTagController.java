package com.example.blog.controller;

import com.example.blog.dto.PostTagDto;
import com.example.blog.service.interf.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post-tag")
public class PostTagController {

    @Autowired
    private PostTagService postTagService;

    @GetMapping("/list")
    public ResponseEntity<List<PostTagDto>> findAllPostTags(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "") String name
    ) {
        List<PostTagDto> list = postTagService.findAllPostTags(title, name);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/save")
    public ResponseEntity<PostTagDto> savePostTag(PostTagDto dto) {
        PostTagDto add = postTagService.savePostTag(dto);
        return new ResponseEntity<>(add, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostTag(Long id) {
        this.postTagService.deletePostTag(id);
    }

}
