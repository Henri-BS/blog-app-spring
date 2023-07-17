package com.example.blog.repository;

import com.example.blog.entity.Answer;
import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Page<Answer> findAllAnswerByComment(Comment comment, Pageable pageable);
}