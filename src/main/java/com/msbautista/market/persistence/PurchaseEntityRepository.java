package com.msbautista.market.persistence;

import com.msbautista.market.domain.Purchase;
import com.msbautista.market.domain.repository.PurchaseRepository;
import com.msbautista.market.persistence.crud.PurchaseCrudRepository;
import com.msbautista.market.persistence.entity.PurchaseEntity;
import com.msbautista.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseEntityRepository implements PurchaseRepository {

    private PurchaseCrudRepository purchaseCrudRepository;
    private PurchaseMapper purchaseMapper;

    @Autowired
    public PurchaseEntityRepository(PurchaseCrudRepository purchaseCrudRepository, PurchaseMapper purchaseMapper) {
        this.purchaseCrudRepository = purchaseCrudRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<PurchaseEntity>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(ps -> purchaseMapper.toPurchases(ps));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = purchaseMapper.toPurchaseEntity(purchase);
        purchaseEntity.getPurchaseProducts().forEach(purchaseProduct -> purchaseProduct.setPurchase(purchaseEntity));
        return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
    }
}
