package com.blog.controller;

import com.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/controllers")
public class CategoryController {

    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
}
