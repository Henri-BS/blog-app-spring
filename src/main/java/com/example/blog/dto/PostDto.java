package com.example.blog.dto;

import com.example.blog.entity.Post;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class PostDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String image;
    private String description;
    private Instant dateCreated;
    private LocalDateTime dateUpdated;
    private UserDto user;

    public PostDto(Post post) {
        id = post.getId();
        title = post.getTitle();
        image = post.getImage();
        description = post.getDescription();
        dateCreated = post.getDateCreated();
        dateUpdated = post.getDateUpdated();
        user = new UserDto(post.getUser());
    }
}
