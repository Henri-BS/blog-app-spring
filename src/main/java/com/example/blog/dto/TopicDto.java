package com.example.blog.dto;

import com.example.blog.entity.Topic;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class TopicDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String body;
    private String image;
    private Integer topicNumber;
    private PostDto post;

    public TopicDto(Topic topic) {
        id = topic.getId();
        title = topic.getTitle();
        body = topic.getBody();
        image = topic.getImage();
        topicNumber = topic.getTopicNumber();
        post = new PostDto(topic.getPost());
    }
}
