package pl.marta.motorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marta.motorest.entity.Motorcycle;

@Repository
public interface MotorcycleRepository extends JpaRepository <Motorcycle, Long> {
}
