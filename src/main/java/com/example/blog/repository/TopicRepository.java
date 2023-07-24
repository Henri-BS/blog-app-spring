package com.example.blog.repository;

import com.example.blog.entity.Post;
import com.example.blog.entity.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("SELECT obj FROM Topic obj WHERE obj.post = ?1 ORDER BY obj.topicNumber")
    Page<Topic> findTopicsByPost(Post post, Pageable pageable);
}