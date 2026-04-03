package app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import app.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    List<Sensor> findByLocal(String local);
}