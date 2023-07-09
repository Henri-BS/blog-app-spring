package com.example.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.Collection;
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
    @NotEmpty(message = "por favor, digite o seu email")
    private String email;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "por favor, digite a sua senha")
    private String password;

    @Column(name="user_name", nullable = false, unique = true)
    @Length(min = 3, max = 80, message = "seu nome de usuário deve ter no mínimo 5 e no máximo 80 caracteres")
    @NotEmpty(message = "por favor, digite o seu nome de usuário")
    private String userName;

    private String image;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private Collection<Comment> comments = new ArrayList<>();

    @Setter(AccessLevel.NONE)
    @Version
    @Column(name = "version")
    private Integer version;

}