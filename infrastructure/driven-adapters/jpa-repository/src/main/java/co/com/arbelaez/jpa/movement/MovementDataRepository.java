package co.com.arbelaez.jpa.movement;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigDecimal;

public interface MovementDataRepository extends CrudRepository<MovementData, String>, QueryByExampleExecutor<MovementData> {

    @Query(value = "SELECT balance FROM movements where id_account=:id order by date desc limit 1",nativeQuery = true)
    BigDecimal currentBalance(@Param("id") String idAccount);
}
