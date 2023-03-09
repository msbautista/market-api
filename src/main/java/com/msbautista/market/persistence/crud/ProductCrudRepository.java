package com.msbautista.market.persistence.crud;

import com.msbautista.market.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    List<ProductEntity> findByCategoryIdOrderByNameAsc(Integer categoryId);

    Optional<List<ProductEntity>> findByStockQuantityLessThanAndState(Integer stockQuantity, Boolean state);

}
