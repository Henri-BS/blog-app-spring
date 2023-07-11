package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long id;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    @Length(min = 3, message = "o comentário deve conter no mínimo 3 caracteres")
    @NotEmpty(message = "o seu comemntário não pode ficar vazio")
    private String body;

    @ElementCollection
    private List<String> images;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "answerTo")
    private Collection<Answer> answerTo;

    @OneToMany(mappedBy = "answerFrom")
    private Collection<Answer> answerFrom;

    @Version
    private Integer version;

}
