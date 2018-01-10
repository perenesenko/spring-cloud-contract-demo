package demo.scc.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andrii Perenesenko
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {
    private Boolean allowed;
}
