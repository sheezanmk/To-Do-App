package com.example.todo;

import java.util.List;

import com.example.todo.dtos.CreateCategoryDto;
import com.example.todo.dtos.UpdateCategoryDto;
import com.example.todo.entities.Category.Category;
import com.example.todo.entities.Todo.Todo;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final TodoRepository todoRepository;

    public CategoryService(CategoryRepository categoryRepository, TodoRepository todoRepository) {

        this.categoryRepository = categoryRepository;
        this.todoRepository = todoRepository;

    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category create(CreateCategoryDto dto) {
        if (categoryRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category(dto.getName());
        return categoryRepository.save(category);
    }

    public Category update(Long id, UpdateCategoryDto dto) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(dto.getName());
        return categoryRepository.save(category);

    }

    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        List<Todo> todos = todoRepository.findByCategory_Id(id);

        for (Todo todo : todos) {
            todo.setCategory(null);
        }

        todoRepository.saveAll(todos);

        categoryRepository.delete(category);
    }

}
