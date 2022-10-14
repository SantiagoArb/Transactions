package co.com.arbelaez.model.movements.gateways;

import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.account.Account;
import co.com.arbelaez.model.movements.Movement;

import java.math.BigDecimal;

public interface MovementsRepository {
    Movement saveMovement(Movement movement);
    Movement findByIdMovement(String id);
    Movement deleteMovement(String id) throws ErrorException;
    BigDecimal currentBalance(String idAccount);
}
