package com.example.todo.config;

import com.example.todo.entities.Category.CategoryRepository;
import com.example.todo.entities.Todo.TodoRepository;
import com.example.todo.entities.Category.Category;
import com.example.todo.entities.Todo.Todo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner seedData(CategoryRepository categoryRepository, TodoRepository todoRepository) {

        return args -> {
            if (categoryRepository.count() > 0) {
                return;
            }

            Category errands = categoryRepository.save(new Category("Errands"));
            Category work = categoryRepository.save(new Category("Work"));

            todoRepository.save(new Todo("Buy Groceries", errands));
            todoRepository.save(new Todo("Pick up parcel from post office", errands));
            todoRepository.save(new Todo("Reply pending emails", work));

        };

    }
}
