package hr.fer.rassus.lti.repository;

import hr.fer.rassus.lti.models.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityRepository extends JpaRepository<Humidity, Integer> {
    Humidity getById(Integer id);
}
