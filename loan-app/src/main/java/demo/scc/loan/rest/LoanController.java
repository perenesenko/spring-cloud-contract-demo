package demo.scc.loan.rest;

import demo.scc.frauddetection.dto.FraudCheckRequest;
import demo.scc.frauddetection.dto.FraudCheckResponse;
import demo.scc.frauddetection.dto.FraudStatus;
import demo.scc.loan.client.FraudDetectionClient;
import demo.scc.loan.dto.LoanRequest;
import demo.scc.loan.dto.LoanResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Andrii Perenesenko
 */
@RestController
public class LoanController {

    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private FraudDetectionClient fraudDetectionClient;


    @PostMapping(path = "/loan-request", produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public LoanResponse requestLoan(@RequestBody LoanRequest request) {
        FraudCheckRequest fraudCheckRequest = new FraudCheckRequest(request.getClientId(), request.getLoanAmount());
        FraudCheckResponse fraudCheckResponse = fraudDetectionClient.fraudCheck(fraudCheckRequest);

        if (fraudCheckResponse.getFraudCheckStatus() == FraudStatus.OK) {
            logger.info("Loan request accepted!");
            return new LoanResponse(true);
        } else {
            logger.info("Loan request rejected: fraud detected");
            return new LoanResponse(false);
        }
    }
}
