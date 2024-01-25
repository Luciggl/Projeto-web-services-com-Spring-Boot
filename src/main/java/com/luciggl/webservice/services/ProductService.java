package com.luciggl.webservice.services;

import com.luciggl.webservice.entities.Product;
import com.luciggl.webservice.entities.User;
import com.luciggl.webservice.repositories.ProductRepository;
import com.luciggl.webservice.services.exceptions.DatabaseException;
import com.luciggl.webservice.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public void delete(long id){
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product insert(Product product){
        return productRepository.save(product);
    }

    public Product update(Product product, long id){
        try {
            Product p = productRepository.getReferenceById(id);
            updateData(p, product);
            return productRepository.save(p);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity,Product obj) {
        entity.setPrice(obj.getPrice());
    }

}
