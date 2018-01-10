package demo.scc.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andrii Perenesenko
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
    private String clientId;
    private Integer loanAmount;
}
