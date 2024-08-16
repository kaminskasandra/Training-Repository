package com.blog.service;

import com.blog.domain.Post;
import com.blog.dto.PostDto;
import com.blog.exceptions.PostNotFoundException;
import com.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;

    public PostDto savePost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        Post savedPost = postRepository.save(post);
        return modelMapper.map(savedPost, PostDto.class);
    }

    public Post updatePost(PostDto postDto, long postId) throws PostNotFoundException {
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException(String.format("Post with id %s not found", postId));
        } else {
            Post post = postRepository.save(modelMapper.map(postDto, Post.class));
            post.setPostId(postId);
            return postRepository.save(post);
        }
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    public Post getPost(final Long postId) throws PostNotFoundException {
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException("Post with id %s not found");
        } else {
            return postRepository.findById(postId).get();
        }
    }

    public void deletePostById(final Long postId) throws PostNotFoundException {
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException("Post with id %s not found");
        } else {
            postRepository.deleteById(postId);
        }
    }
}
