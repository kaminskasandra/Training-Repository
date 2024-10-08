package com.blog.controller;

import com.blog.dto.CategoryDto;
import com.blog.exceptions.CategoryNotFoundException;
import com.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping()
    public List<CategoryDto> findAll() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable long categoryId) throws CategoryNotFoundException {
        return ResponseEntity.ok(modelMapper.map(categoryService.getCategory(categoryId), CategoryDto.class));
    }

    @PutMapping(value = "/{categoryId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable long categoryId) throws CategoryNotFoundException {
        return ResponseEntity.ok(modelMapper.map(categoryService.updateCategory(categoryDto, categoryId), CategoryDto.class));
    }
}
