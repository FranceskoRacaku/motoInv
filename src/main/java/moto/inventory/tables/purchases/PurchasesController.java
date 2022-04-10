package moto.inventory.tables.purchases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://motoang.herokuapp.com")
@RequestMapping(path = "purchases")

public class PurchasesController {

    private final PurchasesService purchasesService;

    @Autowired
    public PurchasesController(PurchasesService purchasesService){
        this.purchasesService = purchasesService;
    }

    @GetMapping
    public List<Purchases> getPurchases(){
        return purchasesService.getPurchases();
    }

    @GetMapping(path = "{id}")
    public Optional<Purchases> getPurchase(@PathVariable Integer id){
        return purchasesService.getPurchase(id);
    }

    @GetMapping(path = "/user/{userId}")
    public List<Purchases> getPurchasesByUser(@PathVariable("userId") Integer userId){
        return purchasesService.getPurchasesByUser(userId);
    }

    @PostMapping
    public void addPurchase(@RequestBody Purchases purchases) {
        purchasesService.addPurchase(purchases);
    }


    @DeleteMapping(path = "{purchaseId}")
    public void deletePurchase(@PathVariable("purchaseId") Integer purchaseId) {
        purchasesService.deletePurchase(purchaseId);
    }

    @PatchMapping("{purchaseId}")
    public ResponseEntity<Purchases> updatePurchase(
            @PathVariable(value = "purchaseId") Integer purchaseId,
            @RequestBody Purchases purchase){
        return new ResponseEntity<Purchases>(purchasesService.updatePurchase(purchase, purchaseId), HttpStatus.OK);

    }
}

