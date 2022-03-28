package moto.inventory.tables.motoInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service

public class MotorsService {

    private final MotorsRepository motorsRepository;

    @Autowired

    public MotorsService(MotorsRepository motorsRepository) {
        this.motorsRepository = motorsRepository;
    }

    public List<Motors> getMotors() {
        return motorsRepository.findAll();
    }

    public Optional<Motors> getMotor(Integer id){
        return motorsRepository.findById(id);

    }

    public void addMotors(Motors motors){
        Optional<Motors> motorsByMake = motorsRepository
                .findMotorsByVin(motors.getVin());
        if(motorsByMake.isPresent()){
            throw new IllegalStateException("VIN Taken");
        }
        motorsRepository.save(motors);
    }

    public void deleteMotor(Integer motorId) {
        boolean exists = motorsRepository.existsById(motorId);
        if (!exists){
            throw new IllegalStateException(
                    "Motor with id "+ motorId + " does not exists!!");
        }
        motorsRepository.deleteById(motorId);
    }

    @Transactional
    public void updateMotor(Integer motorId, String vin, String make, String type) {
        Motors motors = motorsRepository.findById(motorId)
                .orElseThrow(() -> new IllegalStateException(
                        "motor with id " + motorId + " does no exist!!")
                );


        if (vin != null &&
                vin.length() > 0 &&
                !Objects.equals(motors.getVin(), vin)) {
            Optional<Motors> motorsOptional = motorsRepository
                    .findMotorsByVin(vin);
            if (motorsOptional.isPresent()) {
                throw new IllegalStateException("VIN Taken");
            }
            motors.setVin(vin);
        }

        if (make != null &&
                make.length() > 0 &&
                !Objects.equals(motors.getMake(), make)) {
            motors.setMake(make);
        }

        if (type != null &&
                type.length() > 0 &&
                !Objects.equals(motors.getType(), type)) {
            motors.setType(type);
        }
    }
}
