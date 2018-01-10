package demo.scc.loan;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Andrii Perenesenko
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"demo.scc:frauddetection:+:stubs:8080"}, workOffline = true)
public class LoanApplicationServiceTests {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testService2Stub() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/fraudcheck", HttpMethod.PUT,
                new HttpEntity<>("{\"clientId\":\"1234567890\",\"loanAmount\":99999}", httpHeaders),
                String.class);
        Assertions.assertThat(response.getBody()).isEqualTo("{\"fraudCheckStatus\":\"FRAUD\",\"rejectionReason\":\"Amount too high\"}");
    }
}
