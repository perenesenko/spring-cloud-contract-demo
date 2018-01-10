package demo.scc.loan.rest;

import demo.scc.loan.dto.LoanRequest;
import demo.scc.loan.utils.JsonUtils;
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

    private LoanRequest validRequest;
    private LoanRequest invalidRequest;

    @Before
    public void buildRequest() {
        validRequest = new LoanRequest("1234567890", 49999);
        invalidRequest = new LoanRequest("1234567890", 199999);
    }

    @Test
    public void requestLoan() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.post("/loan-request")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.toJsonString(validRequest));
        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.allowed").value(true));
    }

    @Test
    public void requestLoanRejected() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.post("/loan-request")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JsonUtils.toJsonString(invalidRequest));
        mockMvc.perform(req)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.allowed").value(false));
    }
}