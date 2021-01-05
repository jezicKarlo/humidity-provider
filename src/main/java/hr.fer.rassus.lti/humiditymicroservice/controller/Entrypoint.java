package hr.fer.rassus.lti.humiditymicroservice.controller;

import com.lti.humiditymicroservice.response.Response;
import com.lti.humiditymicroservice.service.HumidityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/humidity")
public class Entrypoint {

    private final HumidityService service;

    public Entrypoint(HumidityService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Response> getHumidity() {
        return ResponseEntity.ok(new Response(service.getHumidity()));
    }
}
