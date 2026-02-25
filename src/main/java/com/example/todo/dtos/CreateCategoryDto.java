package com.example.todo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateCategoryDto {

    @NotBlank(message = "Category name is required")
    @Size(max = 60, message = "Category name must be under 60 characters")
    private String name;

    public CreateCategoryDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
