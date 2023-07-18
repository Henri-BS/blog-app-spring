package com.example.blog.dto;

import com.example.blog.entity.Tag;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TagDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String image;
    private String category;

    public TagDto(Tag tag) {
        id = tag.getId();
        name = tag.getName();
        image = tag.getImage();
        category = tag.getCategory();
    }

}
