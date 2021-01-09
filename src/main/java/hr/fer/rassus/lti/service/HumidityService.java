package hr.fer.rassus.lti.service;

import hr.fer.rassus.lti.repository.HumidityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
public class HumidityService {
    private final HumidityRepository repository;

    public Integer getHumidity() {
        return repository.findAll().get(generateId()).getHumidity();
    }

    private int generateId() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        return 4 * hour + minute / 15;
    }
}
