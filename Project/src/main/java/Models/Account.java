package Models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Account {
    @Id
    @GeneratedValue
    private String Iban;

    private BigDecimal balance;
    private AccountType accountType;

    @ManyToOne
    private User user;
}
