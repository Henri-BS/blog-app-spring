package com.example.blog.dto;

import com.example.blog.entity.Answer;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class AnswerDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private CommentDto answerTo;
    private CommentDto answerFrom;

    public AnswerDto(Answer answer) {
        id = answer.getId();
        answerTo = new CommentDto(answer.getAnswerTo());
        answerFrom = new CommentDto(answer.getAnswerFrom());

    }
}
