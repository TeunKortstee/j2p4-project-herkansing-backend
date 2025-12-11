package Models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private final int transactionId;

    private final BigDecimal amount;
    private final LocalDate date;

    @ManyToOne
    private final User initiatedBy;

    @ManyToOne
    private final Account toAccount;

    @ManyToOne
    private final Account fromAccount;

    public Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.amount = builder.amount;
        this.date = builder.date;
        this.initiatedBy = builder.initiatedBy;
        this.toAccount = builder.toAccount;
        this.fromAccount = builder.fromAccount;
    }

    public static class Builder {
        private int transactionId;
        private BigDecimal amount;
        private LocalDate date;
        private User initiatedBy;
        private Account toAccount;
        private Account fromAccount;

        public Builder Id(int transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder Amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder Date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder Initiator(User initiatedBy) {
            this.initiatedBy = initiatedBy;
            return this;
        }

        public Builder Receiver(Account toAccount) {
            this.toAccount = toAccount;
            return this;
        }

        public Builder Sender(Account fromAccount) {
            this.fromAccount = fromAccount;
            return this;
        }

        public Transaction Build() {
            return new Transaction(this);
        }
    }

}
