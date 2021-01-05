package hr.fer.rassus.lti;

import hr.fer.rassus.lti.models.Humidity;
import hr.fer.rassus.lti.repository.HumidityRepository;
import hr.fer.rassus.lti.util.HumidityLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class HumidityProviderApplication {

    public HumidityProviderApplication(HumidityRepository repository) {
        HumidityLoader loader = new HumidityLoader();
        loader.load();
        List<Humidity> humidity = loader.getHumidities().stream()
                .map(Humidity::new)
                .collect(Collectors.toList());
        humidity.forEach(repository::save);
    }

    public static void main(String[] args) {
        SpringApplication.run(HumidityProviderApplication.class, args);
    }
}
