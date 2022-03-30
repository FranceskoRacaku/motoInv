package moto.inventory.tables.motoInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @PatchMapping("{motorId}")
    public ResponseEntity<Motors> updateMotor(
            @PathVariable(value = "motorId") Integer motorId,
            @RequestBody Motors motor){
        return new ResponseEntity<Motors>(motorsService.updateMotor(motor, motorId), HttpStatus.OK);

    }

}
