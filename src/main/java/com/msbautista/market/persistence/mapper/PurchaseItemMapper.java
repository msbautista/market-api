package com.msbautista.market.persistence.mapper;

import com.msbautista.market.domain.PurchaseItem;
import com.msbautista.market.persistence.entity.PurchaseProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "state", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchaseProductEntity purchaseProductEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true)
    })
    PurchaseProductEntity toPurchaseProductEntity(PurchaseItem purchaseItem);

}
