package com.example.blog.controller;

import com.example.blog.dto.TopicDto;
import com.example.blog.entity.Post;
import com.example.blog.service.interf.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/list-by-post/{post}")
    public ResponseEntity<Page<TopicDto>> findTopicsByPost(Post post, Pageable pageable) {
        Page<TopicDto> page = topicService.findTopicsByPost(post, pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/save")
    public ResponseEntity<TopicDto> saveTopic(@RequestBody TopicDto dto) {
        TopicDto add = topicService.saveTopic(dto);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TopicDto> updateTopic(@RequestBody TopicDto dto) {
        TopicDto edit = topicService.updateTopic(dto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopic(Long id) {
        this.topicService.deleteTopic(id);
    }
}
