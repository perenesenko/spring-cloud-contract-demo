package demo.scc.frauddetection.rest;

import demo.scc.frauddetection.dto.FraudCheckRequest;
import demo.scc.frauddetection.dto.FraudCheckResponse;
import demo.scc.frauddetection.dto.FraudStatus;
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
        if (request.getLoanAmount() < 50000) {
            return new FraudCheckResponse(FraudStatus.OK, "");
        } else {
            return new FraudCheckResponse(FraudStatus.FRAUD, "Amount too high");
        }
    }
}
