package com.blog.dto;

import com.blog.domain.Category;
import com.blog.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long postId;
    private String postContent;
    private User user;
    private Category category;
}
