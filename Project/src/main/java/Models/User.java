package Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue
    private int userId;

    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String BSN;

    private String email;
    private String password;

    private Role role;
}
