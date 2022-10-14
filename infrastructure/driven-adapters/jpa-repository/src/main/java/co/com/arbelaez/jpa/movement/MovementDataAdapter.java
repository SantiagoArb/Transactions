package co.com.arbelaez.jpa.movement;

import co.com.arbelaez.jpa.helper.AdapterOperations;
import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.movements.Movement;
import co.com.arbelaez.model.movements.gateways.MovementsRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.function.Function;

@Repository
public class MovementDataAdapter extends AdapterOperations<Movement, MovementData, String, MovementDataRepository> implements MovementsRepository {

    @Autowired
    public MovementDataAdapter(MovementDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d-> mapper.mapBuilder(d, Movement.MovementBuilder.class).build());
    }

    @Override
    public Movement saveMovement(Movement movement) {
        return super.save(movement);
    }

    @Override
    public Movement findByIdMovement(String id) {
        return super.findById(id);
    }

    @Override
    public Movement deleteMovement(String id) throws ErrorException {
        Movement movement = findByIdMovement(id);
        if(movement != null){
            repository.deleteById(id);
            return movement;
        }
        throw new ErrorException("No se el movimiento",404);

    }

    @Override
    public BigDecimal currentBalance(String idAccount){
        return repository.currentBalance(idAccount);
    }
}
