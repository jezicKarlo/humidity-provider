package hr.fer.rassus.lti.response;

import lombok.Data;

@Data
public class Response {

    private Integer humidity;
    private String message;

    public Response(Integer humidity) {
        this.humidity = humidity;
    }
}
