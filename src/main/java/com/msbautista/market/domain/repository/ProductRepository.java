package com.msbautista.market.domain.repository;

import com.msbautista.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarceProducts(int quantity);

    Optional<Product> getById(int productId);

    Product save(Product product);

    void deleteById(int productId);

}
