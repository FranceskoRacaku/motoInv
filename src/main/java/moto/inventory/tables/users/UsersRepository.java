package moto.inventory.tables.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository
        extends JpaRepository<Users, Integer> {



    @Query("SELECT s FROM Users s WHERE s.userName = ?1")
    Optional<Users> findUsersByUserName(String userName);

    @Query("SELECT s FROM Users s WHERE s.userEmail = ?1")
    Optional<Users> findUsersByUserEmail(String userEmail);
}
