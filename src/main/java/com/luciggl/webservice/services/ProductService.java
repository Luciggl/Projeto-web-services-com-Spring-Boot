package com.luciggl.webservice.services;

import com.luciggl.webservice.entities.Product;
import com.luciggl.webservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List findAllProducts(){
        return productRepository.findAll();
    }

    public Product findById(long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

}
