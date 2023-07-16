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
        User find = userRepository.findById(id).orElseThrow();
        return new UserDto(find);
    }

    @Override
    public UserDto saveUser(UserDto dto) {

        User add = new User();
        add.setEmail(dto.getEmail());
        add.setUserName(dto.getUserName());
        add.setPassword(dto.getPassword());
        add.setImage(dto.getImage());

        return new UserDto(userRepository.saveAndFlush(add));
    }

    @Override
    public UserDto updateUser(UserDto dto) {
        User edit = userRepository.findById(dto.getId()).orElseThrow();

        edit.setUserName(dto.getUserName());
        edit.setImage(dto.getImage());
        edit.setPassword(dto.getPassword());
        return new UserDto(userRepository.save(edit));
    }

    @Override
    public void deleteUser(Long id) {

    }
}
