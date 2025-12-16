package Dtos;

import java.math.BigDecimal;

import Models.User;

public class AccountResponseDTO {
    public String Iban;
    public BigDecimal balance;
    public String accountType;
    public BigDecimal absoluteLimit;
    public User user;
}
