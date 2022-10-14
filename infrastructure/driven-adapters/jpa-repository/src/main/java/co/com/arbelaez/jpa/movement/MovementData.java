package co.com.arbelaez.jpa.movement;

import co.com.arbelaez.model.movements.MovementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "movements")
public class MovementData {
    @Id
    @Column(name = "id_movement")
    private String idMovement;
    @Column(name = "type_movement")
    private String movementType;
    private BigDecimal value;
    private BigDecimal balance;
    @Column(name = "id_account")
    private String idAccount;
    private LocalDateTime date;
}
