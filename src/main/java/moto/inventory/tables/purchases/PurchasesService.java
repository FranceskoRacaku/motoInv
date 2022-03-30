package moto.inventory.tables.purchases;


import moto.inventory.tables.motoInventory.Motors;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class PurchasesService {

    private final PurchasesRepository purchasesRepository;

    @Autowired

    public PurchasesService(PurchasesRepository purchasesRepository) {
        this.purchasesRepository = purchasesRepository;
    }

    public List<Purchases> getPurchases() {
        return purchasesRepository.findAll();
    }

    public Optional<Purchases> getPurchase(Integer id){
        return purchasesRepository.findById(id);

    }

    public List<Purchases> getPurchasesByUser(Integer userId){
        return purchasesRepository.findAllById(userId);


    }

    public void addPurchase(Purchases purchases){
        purchasesRepository.save(purchases);

    }

    public void deletePurchase(Integer purchaseId) {
        boolean exists = purchasesRepository.existsById(purchaseId);
        if (!exists){
            throw new IllegalStateException(
                    "Purchase with id "+ purchaseId + " does not exists!!");
        }
        purchasesRepository.deleteById(purchaseId);
    }


    @Transactional
    public Purchases updatePurchase(Purchases purchase, Integer purchaseId) {

        Purchases existingPurchase = purchasesRepository.findById(purchaseId).orElseThrow(
                () -> new ResourceNotFoundException("Purchase Id" + purchaseId));

        existingPurchase.setAmount(purchase.getAmount());
        existingPurchase.setMotorId(purchase.getMotorId());
        existingPurchase.setUserId(purchase.getUserId());

        purchasesRepository.save(existingPurchase);
        return existingPurchase;
    }

}
