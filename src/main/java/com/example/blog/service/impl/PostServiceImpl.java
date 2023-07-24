package com.example.blog.service.impl;

import com.example.blog.dto.PostDto;
import com.example.blog.entity.Post;
import com.example.blog.entity.User;
import com.example.blog.repository.PostRepository;
import com.example.blog.repository.UserRepository;
import com.example.blog.service.interf.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public void defaultPost(){
        String image = "https://apaturkey.com/assets/images/picture.png";
        for (Post post : postRepository.findAll()) {
            if(post.getImage() == null) {
                post.setImage(image);
            }
        }
    }

    @Override
    public PostDto findById(Long id){
        Post find = postRepository.findById(id).orElseThrow();
        return new PostDto(find);
    }

    @Override
    public Page<PostDto> findAllPosts(String title, Pageable pageable) {
        Page<Post> page = postRepository.findAllPostsIgnoreAllCase(title, pageable);



        return page.map(PostDto::new);
    }

    @Override
    public PostDto savePost(PostDto dto) {
        User user = userRepository.findById(dto.getUser().getId()).orElseThrow();

        Post add = new Post();
        add.setTitle(dto.getTitle());
        add.setDescription(dto.getDescription());
        add.setImage(dto.getImage());
        add.setUser(user);
        return new PostDto(postRepository.saveAndFlush(add));
    }

    @Override
    public PostDto updatePost(PostDto dto) {
        Post edit = postRepository.findById(dto.getId()).orElseThrow();

        edit.setId(edit.getId());
        edit.setTitle(dto.getTitle());
        edit.setDescription(dto.getDescription());
        edit.setImage(dto.getImage());
        return new PostDto(postRepository.save(edit));
    }

    @Override
    public void deletePostByUser(User user) {
        this.postRepository.deleteByUser(user);
    }
}
