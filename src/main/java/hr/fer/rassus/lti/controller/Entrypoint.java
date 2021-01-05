package hr.fer.rassus.lti.controller;

import hr.fer.rassus.lti.response.Response;
import hr.fer.rassus.lti.service.HumidityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("current-readings")
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
