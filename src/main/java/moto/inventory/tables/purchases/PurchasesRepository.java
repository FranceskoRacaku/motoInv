package moto.inventory.tables.purchases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchasesRepository
        extends JpaRepository<Purchases, Integer> {

    @Query("SELECT e FROM Purchases e where e.userId = ?1")
    List<Purchases> findAllById(Integer userId);

//    @Query("SELECT s FROM Purchases s WHERE s.userId = ?1")
//    Optional<Purchases> findPurchasesByUserId(String userId);
//
//    @Query("SELECT s FROM Purchases s WHERE s.fundId = ?1")
//    Optional<Purchases> findPurchasesByFundId(String fundId);
}