package com.example.blog.dto;

import com.example.blog.entity.Answer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AnswerDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String body;
    private String image;
    private Long userId;
    private Long commentId;

    public AnswerDto(Answer answer) {
        id = answer.getId();
        body = answer.getBody();
        image = answer.getImage();
        userId = answer.getUser().getId();
        commentId = answer.getComment().getId();

    }
}
