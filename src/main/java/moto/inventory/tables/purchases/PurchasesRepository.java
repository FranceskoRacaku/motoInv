package moto.inventory.tables.purchases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchasesRepository
        extends JpaRepository<Purchases, Integer> {

    @Query("SELECT e FROM Purchases e where e.motorId = ?1")
    List<Purchases> findAllById(Integer motorId);

}