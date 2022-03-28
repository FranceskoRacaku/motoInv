package moto.inventory.tables.sellsPlace;

import moto.inventory.tables.sellsPlace.Sells;
import moto.inventory.tables.sellsPlace.SellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "sells")

public class SellsController {

    private final SellsService sellsService;

    @Autowired
    public SellsController(SellsService sellsService){
        this.sellsService = sellsService;
    }

    @GetMapping
    public List<Sells> getSells(){
        return sellsService.getSells();
    }

    @GetMapping(path = "{id}")
    public Optional<Sells> getSell(@PathVariable Integer id){
        return sellsService.getSell(id);
    }

    @GetMapping(path = "/user/{userId}")
    public List<Sells> getSellsByUser(@PathVariable("userId") Integer userId){
        return sellsService.getSellsByUser(userId);
    }

    @PostMapping
    public void addSell(@RequestBody Sells sells){
        sellsService.addSell(sells);
    }


    @DeleteMapping(path = "{sellId}")
    public void deleteSell(@PathVariable("sellId") Integer sellId) {
        sellsService.deleteSell(sellId);
    }

    @PutMapping(path = "{sellId}")
    public void updateSell(
            @PathVariable("sellId") Integer sellId,
            @RequestParam(required = false) Integer amountSold,
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) Integer motorId){
        sellsService.updateSell(sellId, amountSold, userId, motorId);
    }
}


