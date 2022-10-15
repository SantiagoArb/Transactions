package co.com.arbelaez.jpa.movement;

import co.com.arbelaez.model.movements.ReportData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public interface MovementDataRepository extends CrudRepository<MovementData, String>, QueryByExampleExecutor<MovementData> {

    @Query(value = "SELECT balance FROM movements where id_account=:id order by date desc limit 1",nativeQuery = true)
    BigDecimal currentBalance(@Param("id") String idAccount);

    @Query(name = "report_accounts_by_user",nativeQuery = true)
    List<ReportData> movementsReport(@Param("idClient") String idAccount, @Param("initial")  LocalDateTime initialDate, @Param("final")  LocalDateTime finalDate);
}
