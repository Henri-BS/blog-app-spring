package com.example.blog.service.impl;

import com.example.blog.dto.TopicDto;
import com.example.blog.entity.Post;
import com.example.blog.entity.Topic;
import com.example.blog.repository.TopicRepository;
import com.example.blog.service.interf.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public Page<TopicDto> findTopicsByPost(Post post, Pageable pageable) {
        Page<Topic> page = topicRepository.findTopicsByPost(post, pageable);
        return page.map(TopicDto::new);
    }

    @Override
    public TopicDto saveTopic(TopicDto dto) {
        Topic add = new Topic();
        add.setTitle(dto.getImage());
        add.setBody(dto.getBody());
        add.setImage(dto.getImage());
        add.setTopicNumber(dto.getTopicNumber());

        return new TopicDto(topicRepository.saveAndFlush(add));
    }

    @Override
    public TopicDto updateTopic(TopicDto dto) {
        Topic edit = topicRepository.findById(dto.getId()).orElseThrow();

        edit.setTitle(dto.getTitle());
        edit.setBody(dto.getBody());
        edit.setImage(dto.getImage());
        edit.setTopicNumber(dto.getTopicNumber());

        return new TopicDto(topicRepository.save(edit));
    }

    @Override
    public void deleteTopic(Long id) {
       this.topicRepository.deleteById(id);
    }
}
