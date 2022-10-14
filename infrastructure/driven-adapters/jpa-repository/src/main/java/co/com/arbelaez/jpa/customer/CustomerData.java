package co.com.arbelaez.jpa.customer;

import co.com.arbelaez.jpa.person.PersonData;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "identification")
@Table(name = "customer")
public class CustomerData extends PersonData implements Serializable {
    public String password;
    public boolean state;

    public CustomerData() {
    }

    @Builder
    public CustomerData(String identification, String name, String gender, String age, String address, String phone, String password, boolean state) {
        super(identification, name, gender, age, address, phone);
        this.password = password;
        this.state = state;
    }
}
