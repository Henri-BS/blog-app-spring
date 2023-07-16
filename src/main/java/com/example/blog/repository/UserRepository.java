package com.example.blog.repository;

import com.example.blog.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT obj FROM User obj WHERE UPPER(obj.userName) " +
            "LIKE UPPER(CONCAT('%', ?1, '%')) ORDER BY (obj.userName) DESC")
    Page<User> findAllUsers(String userName, Pageable pageable);
}