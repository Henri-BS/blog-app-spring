package com.example.blog.dto;

import com.example.blog.entity.User;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String password;
    private String userName;
    private String image;

    public UserDto(User user) {
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        userName = user.getUserName();
        image = user.getImage();
    }
}
