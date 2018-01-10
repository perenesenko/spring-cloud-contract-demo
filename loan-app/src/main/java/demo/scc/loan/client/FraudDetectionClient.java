package demo.scc.loan.client;

import demo.scc.frauddetection.dto.FraudCheckRequest;
import demo.scc.frauddetection.dto.FraudCheckResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Andrii Perenesenko
 */
@Service
public class FraudDetectionClient {

    private static final String FRAUD_CHECK_URL = "http://localhost:8080/fraudcheck";

    private RestTemplate restTemplate;
    private HttpHeaders jsonHeaders;

    public FraudDetectionClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        jsonHeaders = new HttpHeaders();
        jsonHeaders.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    public FraudCheckResponse fraudCheck(FraudCheckRequest request) {
        ResponseEntity<FraudCheckResponse> response = restTemplate.exchange(FRAUD_CHECK_URL, HttpMethod.PUT,
                new HttpEntity<>(request, jsonHeaders), FraudCheckResponse.class);
        return response.getBody();
    }
}
