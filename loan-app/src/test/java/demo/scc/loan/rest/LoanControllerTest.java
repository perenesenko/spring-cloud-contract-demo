package demo.scc.loan.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Andrii Perenesenko
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"demo.scc:fraud-detection-app:+:stubs:8080"}, workOffline = true)
@AutoConfigureMockMvc
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String requestJson;

    @Before
    public void buildRequest() {
        requestJson = "{'clientId':'1234567890', 'loanAmount': 99999}"
                .replaceAll("'", "\"");
    }

    @Test
    public void requestLoan() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.post("/loan-request")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson);
        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.allowed").value(false));
    }
}