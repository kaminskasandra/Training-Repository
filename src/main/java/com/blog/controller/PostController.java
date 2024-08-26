package com.blog.controller;

import com.blog.dto.PostDto;
import com.blog.exceptions.PostNotFoundException;
import com.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/posts")
public class PostController {
    private final ModelMapper modelMapper;
    private final PostService postService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(modelMapper.map(postService.savePost(postDto), PostDto.class));
    }

    @DeleteMapping(value = "/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable long postId) throws PostNotFoundException {
        postService.deletePostById(postId);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<PostDto> findAll() {
        List<PostDto> posts = postService.getAllPosts();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long postId) throws PostNotFoundException {
        return ResponseEntity.ok(modelMapper.map(postService.getPost(postId), PostDto.class));
    }

    @PutMapping(value = "/{postId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable long postId) throws PostNotFoundException {
        return ResponseEntity.ok(modelMapper.map(postService.updatePost(postDto, postId), PostDto.class));
    }

}
