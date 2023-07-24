package com.example.blog.service.impl;

import com.example.blog.dto.AnswerDto;
import com.example.blog.entity.Answer;
import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import com.example.blog.repository.AnswerRepository;
import com.example.blog.repository.CommentRepository;
import com.example.blog.repository.UserRepository;
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

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public AnswerDto saveAnswer(AnswerDto dto) {
        Comment comment = commentRepository.findById(dto.getCommentId()).orElseThrow();
        User user = userRepository.findById(dto.getUserId()).orElseThrow();

        Answer add = new Answer();
        add.setBody(dto.getBody());
        add.setImage(dto.getImage());
        add.setComment(comment);
        add.setUser(user);

        return new AnswerDto(answerRepository.saveAndFlush(add));
    }



    @Override
    public AnswerDto updateAnswer(AnswerDto dto) {
        Answer edit = answerRepository.findById(dto.getId()).orElseThrow();
        edit.setBody(dto.getBody());
        edit.setImage(dto.getImage());
        return new AnswerDto(answerRepository.save(edit));
    }

    @Override
    public void deleteAnswer(Long id) {
        this.answerRepository.deleteById(id);
    }
}


