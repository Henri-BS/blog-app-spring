package com.example.blog.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long id;

    @Column(name = "title", columnDefinition = "TEXT", nullable = false)
    @Length(min = 3, message = "o tópico deve conter no mínimo 3 caracteres")
    @NotEmpty(message = "o título do tópico não pode ficar vazio")
    private String title;

    @Column(name = "body", columnDefinition = "TEXT", nullable = false)
    @Length(min = 15, message = "o tópico deve conter no mínimo 15 caracteres")
    @NotEmpty(message = "o tópico não pode ficar vazio")
    private String body;

    private String image;

    private Integer topicNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Version
    private Integer version;

}