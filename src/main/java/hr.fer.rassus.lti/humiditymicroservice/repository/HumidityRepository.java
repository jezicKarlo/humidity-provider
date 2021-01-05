package hr.fer.rassus.lti.humiditymicroservice.repository;

import com.lti.humiditymicroservice.entity.Humidity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityRepository extends JpaRepository<Humidity, Integer> {

    Humidity getById(Integer id);
}
