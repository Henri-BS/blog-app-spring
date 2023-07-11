package com.example.blog.dto;

import com.example.blog.entity.Comment;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class CommentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String body;
    private List<String> images;
    private PostDto post;
    private UserDto user;

    public CommentDto(Comment comment) {
        id = comment.getId();
        body = comment.getBody();
        images = comment.getImages();
        post = new PostDto(comment.getPost());
        user = new UserDto(comment.getUser());
    }
}
