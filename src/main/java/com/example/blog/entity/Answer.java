package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "answer_to")
    private Comment answerTo;

    @ManyToOne
    @JoinColumn(name = "answer_from")
    private Comment answerFrom;

    @Version
    private Integer version;

}
