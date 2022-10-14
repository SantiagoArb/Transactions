package co.com.arbelaez.model.customer;
import co.com.arbelaez.model.person.Person;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends Person {
    String password;
    boolean state;

    @Builder
    public Customer(String identification, String name, String gender, String age, String address, String phone, String password, boolean state) {
        super(identification, name, gender, age, address, phone);
        this.password = password;
        this.state = state;
    }
    public Customer() {
    }
}
