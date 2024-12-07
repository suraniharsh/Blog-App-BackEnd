package com.surani.blog.services.Impl;

import com.surani.blog.exceptions.ResourceNotFoundException;
import com.surani.blog.models.Category;
import com.surani.blog.payloads.Dtos.CategoryDto;
import com.surani.blog.repositorys.CategoryRepo;
import com.surani.blog.services.CategoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServicesImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        return this.modelMapper.map(this.categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer catagoryId) {
        Category category = this.categoryRepo.findById(catagoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", catagoryId));
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        return this.modelMapper.map(this.categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Integer catagoryId) {
        Category category = this.categoryRepo.findById(catagoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", catagoryId));
        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer catagoryId) {
        Category category = this.categoryRepo.findById(catagoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", catagoryId));
        this.categoryRepo.delete(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        return categories.stream().map(category -> this.modelMapper.map(category, CategoryDto.class)).toList();
    }
}
