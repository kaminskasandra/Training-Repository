package com.blog.service;

import com.blog.domain.Comment;
import com.blog.dto.CommentDto;
import com.blog.exceptions.CommentNotFoundException;
import com.blog.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentDto saveComment(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Comment savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    public Comment updateComment(CommentDto commentDto, long commentId) throws CommentNotFoundException {
        if (!commentRepository.existsById(commentId)) {
            throw new CommentNotFoundException(String.format("Comment with id %s not found", commentId));
        } else {
            Comment comment = commentRepository.save(modelMapper.map(commentDto, Comment.class));
            comment.setCommentId(commentId);
            return commentRepository.save(comment);
        }
    }

    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    public Comment getComment(final Long commentId) throws CommentNotFoundException {
        if (!commentRepository.existsById(commentId)) {
            throw new CommentNotFoundException("Comment with id %s not found");
        } else {
            return commentRepository.findById(commentId).get();
        }
    }

    public void deleteCommentById(final Long commentId) throws CommentNotFoundException {
        if (!commentRepository.existsById(commentId)) {
            throw new CommentNotFoundException("Comment with id %s not found");
        } else {
            commentRepository.deleteById(commentId);
        }
    }
}
