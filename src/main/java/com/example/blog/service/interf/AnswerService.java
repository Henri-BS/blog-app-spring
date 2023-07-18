package com.example.blog.service.interf;

import com.example.blog.dto.AnswerDto;
import com.example.blog.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnswerService {
    Page<AnswerDto> findAllAnswerByComment(Comment comment, Pageable pageable);

    AnswerDto findAnswerById(Long id);

    AnswerDto saveAnswer(AnswerDto dto);

    AnswerDto updateAnswer(AnswerDto dto);

    void deleteAnswer(Long id);
}
