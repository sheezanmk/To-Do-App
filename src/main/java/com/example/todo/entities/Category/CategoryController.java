package com.example.todo.entities.Category;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dtos.CreateCategoryDto;
import com.example.todo.dtos.UpdateCategoryDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping()
    public Category create(@Valid @RequestBody CreateCategoryDto dto) {
        return categoryService.create(dto);

    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @Valid @RequestBody UpdateCategoryDto dto) {

        return categoryService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

}
