package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tb_reply")
public class Reply {
    @Id
    @Column(name = "reply_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "answer_to")
    private Answer answerTo;


    @ManyToOne
    @JoinColumn(name = "answer_from")
    private Answer answerFrom;


}
