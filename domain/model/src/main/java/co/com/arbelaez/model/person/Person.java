package co.com.arbelaez.model.person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
    private String identification;
    private String name;
    private String gender;
    private String age;
    private String address;
    private String phone;
}
