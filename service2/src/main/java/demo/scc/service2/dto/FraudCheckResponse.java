package demo.scc.service2.dto;

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

    private String fraudCheckStatus;
    private String rejectionReason;
}