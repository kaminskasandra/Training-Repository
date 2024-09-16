package com.blog.controller;

import com.blog.dto.CategoryDto;
import com.blog.exceptions.CategoryNotFoundException;
import com.blog.exceptions.CommentNotFoundException;
import com.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/categories")
public class CategoryController {

    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(modelMapper.map(categoryService.saveCategory(categoryDto), CategoryDto.class));
    }

    @DeleteMapping(value = "/{categorieId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long categoryId) throws CategoryNotFoundException {
        categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.ok().build();
    }
}
