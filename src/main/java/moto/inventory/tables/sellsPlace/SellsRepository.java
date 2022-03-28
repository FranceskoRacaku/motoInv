package moto.inventory.tables.sellsPlace;

import moto.inventory.tables.sellsPlace.Sells;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellsRepository
        extends JpaRepository<Sells, Integer> {

    @Query("SELECT e FROM Sells e where e.id = ?1")
    List<Sells> findAllById(Integer id);

}