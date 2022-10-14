package co.com.arbelaez.model.movements;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class Movement {
    private String idMovement;
    private MovementType movementType;
    private BigDecimal value;
    private BigDecimal balance;
    private String idAccount;
    private LocalDateTime date;
}
