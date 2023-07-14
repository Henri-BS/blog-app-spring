package com.example.blog.repository;

import com.example.blog.entity.Answer;
import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    void deleteByAnswerTo(Comment answerTo);

}