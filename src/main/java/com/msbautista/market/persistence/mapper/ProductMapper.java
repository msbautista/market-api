package com.msbautista.market.persistence.mapper;

import com.msbautista.market.domain.Product;
import com.msbautista.market.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "state", target = "active")
    })
    Product toProduct(ProductEntity productEntity);
    List<Product> toProducts(List<ProductEntity> productEntities);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    @Mapping(target = "purchaseProducts", ignore = true)
    ProductEntity toProductEntity(Product product);
}
