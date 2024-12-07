package com.surani.blog.controllers;

import com.surani.blog.payloads.ApiResponse;
import com.surani.blog.payloads.Dtos.CategoryDto;
import com.surani.blog.services.CategoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryControllers {

    private final CategoryServices categoryServices;

    public CategoryControllers(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(this.categoryServices.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @PutMapping("/{catagoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("catagoryId") Integer catagoryId) {
        return new ResponseEntity<>(this.categoryServices.updateCategory(categoryDto, catagoryId), HttpStatus.OK);
    }

    @GetMapping("/{catagoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("catagoryId") Integer catagoryId) {
        return new ResponseEntity<>(this.categoryServices.getCategoryById(catagoryId), HttpStatus.OK);
    }

    @DeleteMapping("/{catagoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catagoryId") Integer catagoryId) {
        this.categoryServices.deleteCategory(catagoryId);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully") ,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(this.categoryServices.getAllCategories(), HttpStatus.OK);
    }


}
