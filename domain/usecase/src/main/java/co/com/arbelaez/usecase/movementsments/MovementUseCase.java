package co.com.arbelaez.usecase.movementsments;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.movements.Movement;
import co.com.arbelaez.model.movements.MovementType;
import co.com.arbelaez.model.movements.ReportData;
import co.com.arbelaez.model.movements.gateways.MovementsRepository;
import co.com.arbelaez.usecase.account.AccountUseCase;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class MovementUseCase {

    private final MovementsRepository movementsRepository;
    private final AccountUseCase accountUseCase;

    public Movement saveMovement(Movement movement) throws ErrorException {
        movement.setDate(LocalDateTime.now());
        BigDecimal lastBalance = currentBalance(movement.getIdAccount());
        BigDecimal newBalance;
        if (lastBalance != null){
            newBalance = calculateBalance(movement.getMovementType(), lastBalance, movement.getValue());
        }else{
            lastBalance = accountUseCase.findAccountById(movement.getIdAccount()).getInitialBalance();
            newBalance = calculateBalance(movement.getMovementType(), lastBalance,movement.getValue());
        }

        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new ErrorException("Saldo insuficiente para realizar esta operacion", 403);
        }
         movement.setBalance(newBalance);
        if (movement.getIdMovement() == null){
            movement.setIdMovement(UUID.randomUUID().toString());
        }
        return movementsRepository.saveMovement(movement);
    }

    public Movement deleteMovement(String id) throws ErrorException {
        return movementsRepository.deleteMovement(id);
    }

    public BigDecimal currentBalance(String idAccount){
        return movementsRepository.currentBalance(idAccount);
    }

    public BigDecimal calculateBalance(MovementType movementType, BigDecimal currentBalance, BigDecimal value){
        return currentBalance.add(value);
    }

    public List<ReportData> movementReport(String idClient, LocalDateTime initialDate, LocalDateTime finalDate){
        return movementsRepository.movementsReport(idClient, initialDate, finalDate);
    }
}
