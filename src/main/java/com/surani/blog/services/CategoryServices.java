package com.surani.blog.services;

import com.surani.blog.payloads.Dtos.CategoryDto;

import java.util.List;

public interface CategoryServices {

//    Create Category
    CategoryDto createCategory(CategoryDto categoryDto);

//    Update Category
    CategoryDto updateCategory(CategoryDto categoryDto, Integer catagoryId);

//    Get Category by Id
    CategoryDto getCategoryById(Integer catagoryId);

//    Delete Category
    void deleteCategory(Integer catagoryId);

//    get all categories
    List<CategoryDto> getAllCategories();


}
