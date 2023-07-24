package com.example.blog.controller;

import com.example.blog.dto.TagDto;
import com.example.blog.service.interf.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseEntity<Page<TagDto>> findAllTags(@RequestParam(defaultValue = "") String name, Pageable pageable) {
        Page<TagDto> page = tagService.findAllTags(name, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> findTagById(@PathVariable Long id) {
        TagDto find = tagService.findTagById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping("/save")
    public ResponseEntity<TagDto> saveTag(@RequestBody TagDto dto) {
        TagDto add = tagService.saveTag(dto);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TagDto> updateTag(@RequestBody TagDto dto) {
        TagDto edit = tagService.updateTag(dto);
        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable Long id) {
        this.tagService.deleteTag(id);
    }
}
