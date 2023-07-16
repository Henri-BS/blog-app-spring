package com.example.blog.service.interf;

import com.example.blog.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> findAllUsers(String userName, Pageable pageable);

    UserDto findUserById(Long id);

    UserDto saveUser(UserDto dto);

    UserDto updateUser(UserDto dto);

    void deleteUser(Long id);
}
