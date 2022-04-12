package com.example.practice.rest;

import com.example.practice.dao.BaseDao;
import com.example.practice.dao.RecipeDao;
import com.example.practice.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {

    BaseDao dao;

    @Autowired
    public RecipeController(@Qualifier("recipeDao") BaseDao dao) {
        this.dao = dao;
    }

    @PostMapping("save")
    public ResponseEntity<?> save(Recipe recipe) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dao.save(recipe));
    }




    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
