package com.example.blog.repository;

import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteAllByUser(User user);
}