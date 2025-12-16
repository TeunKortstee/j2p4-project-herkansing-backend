package Dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import Models.Account;
import Models.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransactionResponseDTO {
    public int transactionId;
    public BigDecimal amount;
    public LocalDate date;
    public User initiatedBy;
    public Account toAccount;
    public Account fromAccount;
}
