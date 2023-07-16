package com.example.blog.controller;

import com.example.blog.dto.UserDto;
import com.example.blog.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<Page<UserDto>> findAllUsers(@RequestParam(defaultValue = "") String userName, Pageable pageable) {
        Page<UserDto> page = userService.findAllUsers(userName, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
     UserDto find = userService.findUserById(id);
     return ResponseEntity.ok(find);
    }
}
