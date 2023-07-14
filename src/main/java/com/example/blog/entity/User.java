package com.example.blog.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "o seu email não pode ficar vazio")
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "a sua senha não pode ficar vazia")
    private String password;

    @Column(name="user_name", nullable = false, unique = true)
    @Length(min = 3, max = 80, message = "seu nome de usuário deve ter no mínimo 5 e no máximo 80 caracteres")
    @NotEmpty(message = "o seu nome de usuário não pode ficar vazio")
    private String userName;

    private String image;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Version
    private Integer version;

}