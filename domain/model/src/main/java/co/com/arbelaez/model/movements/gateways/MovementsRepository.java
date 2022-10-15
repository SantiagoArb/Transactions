package co.com.arbelaez.model.movements.gateways;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.movements.Movement;
import co.com.arbelaez.model.movements.ReportData;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface MovementsRepository {
    Movement saveMovement(Movement movement);
    Movement findByIdMovement(String id);
    Movement deleteMovement(String id) throws ErrorException;
    BigDecimal currentBalance(String idAccount);
    List<ReportData> movementsReport(String idClient, LocalDateTime initialDate, LocalDateTime finalDate);
}
