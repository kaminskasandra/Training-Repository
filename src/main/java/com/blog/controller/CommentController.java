package com.blog.controller;

import com.blog.dto.CommentDto;
import com.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
