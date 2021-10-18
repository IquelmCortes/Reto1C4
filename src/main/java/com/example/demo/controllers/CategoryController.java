package com.example.demo.controllers;

import com.example.demo.persistence.entities.Category;
import com.example.demo.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/Category")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping(path = "/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category category1 = categoryService.saveEntity(category);
        if (category1.getName() == null){
            return new ResponseEntity<>(category1, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public List<Category> showCategories(){
        return categoryService.getEntity();
    }
}
