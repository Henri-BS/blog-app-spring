package com.example.blog.service.interf;

import com.example.blog.dto.TopicDto;
import com.example.blog.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TopicService {
    Page<TopicDto> findTopicsByPost(Post post, Pageable pageable);

    TopicDto updateTopic(TopicDto dto);

    void deleteTopic(Long id);

    TopicDto saveTopic(TopicDto dto);
}
