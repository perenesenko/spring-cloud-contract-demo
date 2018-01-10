package demo.scc.frauddetection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andrii Perenesenko
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckResponse {
    private FraudStatus fraudCheckStatus;
    private String rejectionReason;
}
