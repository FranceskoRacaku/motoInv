package moto.inventory.tables.motoInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "motors")

public class MotorsController {

    private final MotorsService motorsService;

    @Autowired
    public MotorsController(MotorsService motorsService) {
        this.motorsService = motorsService;
    }

    @GetMapping
    public List<Motors> getMotors() {
        return motorsService.getMotors();

    }

    @GetMapping(path = "{id}")
    public Optional<Motors> getMotor(@PathVariable Integer id){
        return motorsService.getMotor(id);
    }

    @PostMapping
    public void addMotor(@RequestBody Motors motors) {
        motorsService.addMotors(motors);
    }


    @DeleteMapping(path = "{motorId}")
    public void deleteMotor(@PathVariable("motorId") Integer motorId) {
        motorsService.deleteMotor(motorId);
    }

    @PutMapping(path = "{motorId}")
    public void updateMotor(
            @PathVariable("motorId") Integer motorId,
            @RequestParam(required = false) String vin,
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String type){
        motorsService.updateMotor(motorId, vin, make, type);

    }

}
