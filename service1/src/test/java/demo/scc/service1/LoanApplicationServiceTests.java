package demo.scc.service1;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Andrii Perenesenko
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"demo.scc.service2"})
public class LoanApplicationServiceTests {
}
