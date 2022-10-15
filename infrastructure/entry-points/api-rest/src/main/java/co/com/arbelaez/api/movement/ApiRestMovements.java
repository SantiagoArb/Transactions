package co.com.arbelaez.api.movement;

import co.com.arbelaez.api.utils.SuccessResponse;
import co.com.arbelaez.model.Exception.ErrorException;
import co.com.arbelaez.model.movements.Movement;
import co.com.arbelaez.usecase.movementsments.MovementUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/api/v1/movements", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRestMovements {

    private static final String SUCCESS_MESSAGE = "Operacion Exitosa";
    private static final String ERROR_MESSAGE = "Operacion Fallida";

    private final MovementUseCase movementUseCase;


    @PostMapping()
    public ResponseEntity<Object> saveMovement(@RequestBody Movement movement){
        try{
            return ResponseEntity.ok(SuccessResponse.success("Movement", movementUseCase.saveMovement(movement),SUCCESS_MESSAGE));
        }catch (ErrorException ex){
            return ResponseEntity.ok(SuccessResponse.error(ex.getMessage() != null? ex.getMessage(): ex.getCause().getMessage(),ex.getCode()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMovement(@PathVariable String id) throws ErrorException {
        try
        {
            return ResponseEntity.ok(SuccessResponse.success("Delete", movementUseCase.deleteMovement(id),SUCCESS_MESSAGE));
        }catch (ErrorException ex){
            return ResponseEntity.ok(SuccessResponse.error(ex.getMessage(),ex.getCode()));
        }

    }

    @GetMapping("/reports")
    public ResponseEntity<Object> movementReport(@RequestParam String idClient,@RequestParam String initialDate, @RequestParam String finalDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return ResponseEntity.ok(SuccessResponse.success("Movement", movementUseCase.movementReport(idClient,LocalDateTime.parse(initialDate,formatter) , LocalDateTime.parse(finalDate,formatter)),SUCCESS_MESSAGE));
    }
}
