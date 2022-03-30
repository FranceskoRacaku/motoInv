package moto.inventory.tables.motoInventory;

import org.apache.velocity.exception.ResourceNotFoundException;
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
    public Motors updateMotor(Motors motor, Integer motorId) {

        Motors existingMotor = motorsRepository.findById(motorId).orElseThrow(
                () -> new ResourceNotFoundException("Motor Id" + motorId));

        existingMotor.setVin(motor.getVin());
        existingMotor.setMake(motor.getMake());
        existingMotor.setType(motor.getType());

        motorsRepository.save(existingMotor);
        return existingMotor;
    }
}