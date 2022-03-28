//package moto.inventory.tables.motoInventory;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface MotorsRepository
//        extends JpaRepository<Motors, Integer> {
//
//    @Query("SELECT s FROM Motors s WHERE s.vin = ?1")
//    Optional<Motors> findMotorsByVin(String vin);
//
////    @Query("SELECT s FROM Motors s WHERE s.type = ?1")
////    Optional<Motors> findMotorsByType(String type);
//}
