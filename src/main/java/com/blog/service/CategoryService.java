package com.blog.service;

import com.blog.domain.Category;
import com.blog.dto.CategoryDto;
import com.blog.exceptions.CategoryNotFoundException;
import com.blog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    public Category updateCategory(CategoryDto categoryDto, long categortId) throws CategoryNotFoundException {
        if (!categoryRepository.existsById(categortId)) {
            throw new CategoryNotFoundException(String.format("Category with id %s not found", categortId));
        } else {
            Category category = categoryRepository.save(modelMapper.map(categoryDto, Category.class));
            category.setCategoryId(categortId);
            return categoryRepository.save(category);
        }
    }

    public void deleteCategoryById(final Long categoryId) throws CategoryNotFoundException {
        if (!categoryRepository.existsById(categoryId)) {
            throw new CategoryNotFoundException("Category with id %s not found");
        } else {
            categoryRepository.deleteById(categoryId);
        }
    }

    public Category getCategory(final Long categoryId) throws CategoryNotFoundException {
        if (!categoryRepository.existsById(categoryId)) {
            throw new CategoryNotFoundException("Category with id %s not found");
        } else {
            return categoryRepository.findById(categoryId).get();
        }
    }

    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }
}
