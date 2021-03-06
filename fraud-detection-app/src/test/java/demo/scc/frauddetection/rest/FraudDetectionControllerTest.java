package demo.scc.frauddetection.rest;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

/**
 * @author Andrii Perenesenko
 */
public class FraudDetectionControllerTest {

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(new FraudDetectionController());
    }
}