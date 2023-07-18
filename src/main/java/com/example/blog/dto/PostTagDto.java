package com.example.blog.dto;

import com.example.blog.entity.PostTag;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class PostTagDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private PostDto post;
    private TagDto tag;

    public PostTagDto(PostTag postTag) {
        id = postTag.getId();
        post = new PostDto(postTag.getPost());
        tag = new TagDto(postTag.getTag());
    }
}
