package com.example.blog.service.impl;

import com.example.blog.dto.AnswerDto;
import com.example.blog.entity.Answer;
import com.example.blog.entity.Comment;
import com.example.blog.repository.AnswerRepository;
import com.example.blog.service.interf.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Page<AnswerDto> findAllAnswerByComment(Comment comment, Pageable pageable) {
        Page<Answer> page = answerRepository.findAllAnswerByComment(comment, pageable);
        return page.map(AnswerDto::new);
    }

    @Override
    public AnswerDto findAnswerById(Long id) {
        Answer find = answerRepository.findById(id).orElseThrow();
        return new AnswerDto(find);
    }
}
