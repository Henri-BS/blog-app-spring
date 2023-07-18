package com.example.blog.dto;

import com.example.blog.entity.Comment;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@NoArgsConstructor
@Getter
@Setter
public class CommentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String body;
    private String image;
    private PostDto post;
    private UserDto user;

    public CommentDto(Comment comment) {
        id = comment.getId();
        body = comment.getBody();
        image = comment.getImage();
        post = new PostDto(comment.getPost());
        user = new UserDto(comment.getUser());
    }
}
