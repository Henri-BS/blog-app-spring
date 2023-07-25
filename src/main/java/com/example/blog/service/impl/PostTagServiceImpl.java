package com.example.blog.service.impl;

import com.example.blog.dto.PostTagDto;
import com.example.blog.entity.Post;
import com.example.blog.entity.PostTag;
import com.example.blog.entity.Tag;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.PostTagRepository;
import com.example.blog.repository.TagRepository;
import com.example.blog.service.interf.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostTagServiceImpl implements PostTagService {

    @Autowired
    private PostTagRepository postTagRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<PostTagDto> findAllPostTags(String post, String tag) {
        List<PostTag> list = postTagRepository.findAllPostTags(post, tag);
        return list.stream().map(PostTagDto::new).collect(Collectors.toList());
    }

    @Override
    public PostTagDto savePostTag(PostTagDto dto) {
        Tag tag = tagRepository.findById(dto.getTag().getId()).orElseThrow();
        Post post = postRepository.findById(dto.getPost().getId()).orElseThrow();

        PostTag add = new PostTag();
        add.setTag(tag);
        add.setPost(post);
        return new PostTagDto(postTagRepository.saveAndFlush(add));
    }

    @Override
    public void deletePostTag(Long id) {
this.postTagRepository.deleteById(id);
    }
}
