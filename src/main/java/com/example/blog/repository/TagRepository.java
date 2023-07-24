package com.example.blog.repository;

import com.example.blog.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT obj FROM Tag obj WHERE UPPER(obj.name) " +
            "LIKE UPPER(CONCAT('%', ?1, '%')) ORDER BY (obj.name) DESC")
    Page<Tag> findAllTags(String name, Pageable pageable);

}