package moto.inventory.tables.sellsPlace;


import moto.inventory.tables.purchases.Purchases;
import moto.inventory.tables.sellsPlace.Sells;
import moto.inventory.tables.sellsPlace.SellsRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class SellsService {

    private final SellsRepository sellsRepository;

    @Autowired

    public SellsService(SellsRepository sellsRepository) {
        this.sellsRepository = sellsRepository;
    }

    public List<Sells> getSells() {
        return sellsRepository.findAll();
    }

    public Optional<Sells> getSell(Integer id){
        return sellsRepository.findById(id);

    }

    public List<Sells> getSellsByUser(Integer userId){
        return sellsRepository.findAllById(userId);


    }

    public void addSell(Sells sells){
        sellsRepository.save(sells);

    }

    public void deleteSell(Integer sellId) {
        boolean exists = sellsRepository.existsById(sellId);
        if (!exists){
            throw new IllegalStateException(
                    "Purchase with id "+ sellId + " does not exists!!");
        }
        sellsRepository.deleteById(sellId);
    }


    @Transactional
    public Sells updateSell(Sells sell, Integer sellId) {

        Sells existingSell = sellsRepository.findById(sellId).orElseThrow(
                () -> new ResourceNotFoundException("Purchase Id" + sellId));

        existingSell.setAmountSold(sell.getAmountSold());
        existingSell.setMotorId(sell.getMotorId());
        existingSell.setUserId(sell.getUserId());

        sellsRepository.save(existingSell);
        return existingSell;
    }

}
