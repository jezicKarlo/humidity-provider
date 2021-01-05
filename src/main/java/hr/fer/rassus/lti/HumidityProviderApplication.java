package hr.fer.rassus.lti;

import hr.fer.rassus.lti.repository.HumidityRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        SpringApplication.run(HumidityMicroserviceApplication.class, args);
    }
}
