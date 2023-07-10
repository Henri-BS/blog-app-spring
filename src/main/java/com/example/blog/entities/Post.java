package com.example.blog.entities;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title", nullable = false, unique = true)
    @Length(min = 3, message = "o título deve conter no mínimo 3 caracteres")
    @NotEmpty(message = "a sua publicação  um título")
    private String title;

    private String image;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Length(min = 3, message = "a descrição deve conter no mínimo 3 caracteres")
    @NotEmpty(message = "a sua publicação precisa de uma descrição")
    private String description;

    @CreationTimestamp
    @Column(name = "date_created")
    private Instant dateCreated;

    @UpdateTimestamp
    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @OneToMany(mappedBy = "post")
    private Collection<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private Collection<Topic> topics = new ArrayList<>();


    @OneToMany(mappedBy = "post")
    private Collection<PostTag> postTags = new ArrayList<>();

    @Version
    @Column(name = "version")
    private Integer version;

}