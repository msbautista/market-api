package com.msbautista.market.domain.service;

import com.msbautista.market.domain.Product;
import com.msbautista.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getById(int productId) {
        return productRepository.getById(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteById(int productId) {
        try {
            productRepository.deleteById(productId);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

}
