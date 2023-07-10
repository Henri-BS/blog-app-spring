package com.example.blog.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "tag_name", nullable = false)
    @Length(min = 3, message = "a tag deve conter no mínimo 3 caracteres")
    @NotEmpty(message = "o nome da tag não pode ficar vazio")
    private String name;
    private String image;
    private String category;

    @OneToMany(mappedBy = "tag")
    private Collection<PostTag> postTag = new ArrayList<>();

    @Version
    private Integer version;

}