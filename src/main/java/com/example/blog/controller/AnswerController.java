package com.example.blog.controller;

import com.example.blog.dto.AnswerDto;
import com.example.blog.entity.Comment;
import com.example.blog.service.interf.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/list")
    public ResponseEntity<Page<AnswerDto>> findAllAnswerByComment(Comment comment, Pageable pageable) {
        Page<AnswerDto> page = answerService.findAllAnswerByComment(comment, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDto> findAnswerById(@PathVariable Long id) {
        AnswerDto find = answerService.findAnswerById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping("/save")
    public ResponseEntity<AnswerDto> saveAnswer(@RequestBody AnswerDto dto) {
    AnswerDto add = answerService.saveAnswer(dto);
    return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AnswerDto> updateAnswer(@RequestBody AnswerDto dto) {
        AnswerDto edit = answerService.updateAnswer(dto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        this.answerService.deleteAnswer(id);
    }
    }
