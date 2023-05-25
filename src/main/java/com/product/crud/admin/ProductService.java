package com.product.crud.admin;

import com.product.crud.admin.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return (List<Product>) repository.findAll();
    }

    public void save(Product product) {
        repository.save(product);
    }

    public Product getProductWith(Integer id) throws ProductNotFoundException {
        Optional<Product> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ProductNotFoundException("Can not found product with " + id);
    }

    public void deleteProductWith(Integer id) throws ProductNotFoundException {
        Optional<Product> result = repository.findById(id);

        if (result.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ProductNotFoundException("Product not exists");
        }
    }
}
