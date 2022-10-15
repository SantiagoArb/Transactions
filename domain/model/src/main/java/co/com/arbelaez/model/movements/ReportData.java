package co.com.arbelaez.model.movements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ReportData {
    private String date;
    private String name;
    private String accountNumber;
    private String accountType;
    private String initialBalance;
    private String value;
    private String balance;
    private String state;
}
