package co.com.arbelaez.jpa.movement;

import co.com.arbelaez.model.movements.ReportData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "movements")
@NamedNativeQuery(
        name = "report_accounts_by_user",
        query =
                "select m.date_mov, p.name, a.account_number as accountNumber, a.account_type as accountType, " +
                        "a.initial_balance as initialBalance,m.value_mov, m.balance, a.state from account a, " +
                        "person p, movements m where p.identification=:idClient and " +
                        "a.id_customer =p.identification and a.account_number = m.id_account and m.date_mov BETWEEN :initial AND :final",
        resultSetMapping = "report_data"
)
@SqlResultSetMapping(
        name = "report_data",
        classes = @ConstructorResult(
                targetClass = ReportData.class,
                columns = {
                        @ColumnResult(name = "date_mov", type = String.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "accountNumber", type = String.class),
                        @ColumnResult(name = "accountType", type = String.class),
                        @ColumnResult(name = "initialBalance", type = String.class),
                        @ColumnResult(name = "value_mov", type = String.class),
                        @ColumnResult(name = "balance", type = String.class),
                        @ColumnResult(name = "state", type = String.class)
                }
        )
)
public class MovementData {
    @Id
    @Column(name = "id_movement")
    private String idMovement;
    @Column(name = "type_movement")
    private String movementType;
    @Column(name = "value_mov")
    private BigDecimal value;
    private BigDecimal balance;
    @Column(name = "id_account")
    private String idAccount;
    @Column(name = "date_mov")
    private LocalDateTime date;
}
