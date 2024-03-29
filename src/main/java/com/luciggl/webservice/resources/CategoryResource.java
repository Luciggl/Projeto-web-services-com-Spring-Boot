package com.luciggl.webservice.resources;

import com.luciggl.webservice.entities.Category;
import com.luciggl.webservice.entities.Order;
import com.luciggl.webservice.services.CategoryService;
import com.luciggl.webservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findByid(@PathVariable long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
