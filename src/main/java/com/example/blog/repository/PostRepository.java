package com.example.blog.repository;

import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    @Query("SELECT obj FROM Post obj WHERE UPPER(obj.title) " +
            "LIKE UPPER(concat('%', ?1, '%')) ORDER BY obj.dateCreated DESC")
    Page<Post> findAllPostsIgnoreAllCase(String title, Pageable pageable);


    void deleteByUser(User user);
}