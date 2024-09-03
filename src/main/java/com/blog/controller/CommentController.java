package com.blog.controller;

import com.blog.dto.CommentDto;
import com.blog.exceptions.CommentNotFoundException;
import com.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/comments")
public class CommentController {

    private final ModelMapper modelMapper;
    private final CommentService commentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentDto commentDto) {
        return ResponseEntity.ok(modelMapper.map(commentService.saveComment(commentDto), CommentDto.class));
    }

    @DeleteMapping(value = "/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable long commentId) throws CommentNotFoundException {
        commentService.deleteCommentById(commentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public List<CommentDto> findAll() {
        List<CommentDto> comments = commentService.getAllComments();
        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable long commentId) throws CommentNotFoundException {
        return ResponseEntity.ok(modelMapper.map(commentService.getCommentById(commentId), CommentDto.class));
    }

    @PutMapping(value = "/{commentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto, @PathVariable long commentId) throws CommentNotFoundException {
        return ResponseEntity.ok(modelMapper.map(commentService.updateComment(commentDto, commentId), CommentDto.class));
    }
}
