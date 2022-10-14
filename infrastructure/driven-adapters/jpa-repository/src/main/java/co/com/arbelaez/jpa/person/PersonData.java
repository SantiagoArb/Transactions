package co.com.arbelaez.jpa.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonData {
    @Id
    private String identification;
    private String name;
    private String gender;
    private String age;
    private String address;
    private String phone;
}
