package com.example.todo.entities.Todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByIsArchivedFalse();

    List<Todo> findByIsArchivedFalseAndCategory_NameIgnoreCase(String categoryName);

    List<Todo> findByCategory_Id(Long categoryId);
}