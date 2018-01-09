package demo.scc.service2.controller;

import demo.scc.service2.dto.FraudCheckRequest;
import demo.scc.service2.dto.FraudCheckResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Andrii Perenesenko
 */
@RestController
public class FraudDetectionController {

    @PutMapping(path = "/fraudcheck", produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public FraudCheckResponse check(@RequestBody FraudCheckRequest request) {
        return new FraudCheckResponse("FRAUD", "Amount too high");
    }
}