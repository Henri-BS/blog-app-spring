package com.example.blog.repository;

import com.example.blog.entity.Post;
import com.example.blog.entity.PostTag;
import com.example.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, Long> {

    @Query("SELECT obj FROM PostTag obj " +
            "WHERE UPPER(obj.tag.name) LIKE UPPER(CONCAT('%', ?1, '%')) " +
            "AND UPPER(obj.post.title) LIKE UPPER(CONCAT('%', ?1, '%')) ")
    List<PostTag> findAllPostTags(String post, String tag);

}