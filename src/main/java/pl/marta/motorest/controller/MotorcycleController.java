package pl.marta.motorest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.marta.motorest.entity.Motorcycle;
import pl.marta.motorest.exception.ResourceNotFoundException;
import pl.marta.motorest.repository.MotorcycleRepository;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/moto")
public class MotorcycleController {

    @Autowired
    MotorcycleRepository motorcycleRepository;


    // List of motorcycles

    @GetMapping("/motorcycles")
    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

    //saveOne

    @PostMapping("/motorcycles")
    public Motorcycle createMotorcycle(@Valid @RequestBody Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    //getMotorcycle

    @GetMapping("/motorcycles/{id}")
    public Motorcycle getMotorcycle(@PathVariable(value = "id") long id) {
        return motorcycleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "id", id));
    }


    //updateMotorcycle

    @PutMapping("/motorcycles/{id}")
    public Motorcycle putMotorcycle(@PathVariable(value = "id") long id, @Valid @RequestBody Motorcycle newMoto) {
        Motorcycle motorcycle = motorcycleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "id", id));
        motorcycle.setModel(newMoto.getModel());
        return motorcycleRepository.save(motorcycle);

    }

    //deleteMotorcycle

    @DeleteMapping("/motorcycles/{id}")
    public ResponseEntity<?> deleteMotorcycle (@PathVariable(value ="id") long id){
        Motorcycle motorcycle = motorcycleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Motorcycle", "id", id));
        motorcycleRepository.delete(motorcycle);
        return  ResponseEntity.ok().build();
    }


}

