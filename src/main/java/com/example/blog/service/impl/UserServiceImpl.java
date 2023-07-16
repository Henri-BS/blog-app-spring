package com.example.blog.service.impl;

import com.example.blog.dto.UserDto;
import com.example.blog.entity.User;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<UserDto> findAllUsers(String userName, Pageable pageable) {
        Page<User> page = userRepository.findAllUsers(userName, pageable);
        return page.map(UserDto::new);
    }

    @Override
    public UserDto findUserById(Long id) {
        return null;
    }
}
