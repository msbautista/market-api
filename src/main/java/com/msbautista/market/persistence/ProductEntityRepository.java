package com.msbautista.market.persistence;

import com.msbautista.market.domain.Product;
import com.msbautista.market.domain.repository.ProductRepository;
import com.msbautista.market.persistence.crud.ProductCrudRepository;
import com.msbautista.market.persistence.entity.ProductEntity;
import com.msbautista.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductEntityRepository implements ProductRepository {

    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    @Autowired
    public ProductEntityRepository(ProductCrudRepository productCrudRepository, ProductMapper mapper) {
        this.productCrudRepository = productCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity savedProductEntity = productCrudRepository.save(mapper.toProductEntity(product));
        return mapper.toProduct(savedProductEntity);
    }

    @Override
    public List<Product> getAll() {
        List<ProductEntity> all = (List<ProductEntity>) productCrudRepository.findAll();
        return mapper.toProducts(all);
    }

    @Override
    public Optional<Product> getById(int productId) {
        Optional<ProductEntity> productEntity = productCrudRepository.findById(productId);
        return productEntity.map(p -> mapper.toProduct(p));
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> productEntities = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(productEntities));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<ProductEntity>> productEntities = productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
        return productEntities.map(ps -> mapper.toProducts(ps));
    }

    @Override
    public void deleteById(int productId) {
        productCrudRepository.deleteById(productId);
    }

}
