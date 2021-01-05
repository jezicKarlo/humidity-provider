package hr.fer.rassus.lti.service;

import hr.fer.rassus.lti.repository.HumidityRepository;
import org.springframework.stereotype.Service;

@Service
public class HumidityService {

    private final HumidityRepository repository;

    public HumidityService(HumidityRepository repository) {
        this.repository = repository;
    }

    public Integer getHumidity() {
        int id = generateId();
        return repository.findAll().get(id).getHumidity();
        //return repository.getById(id).getHumidity();
    }

    private int generateId() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        return 4 * hour + minute / 15;
    }
}
