package com.example24.Backend.Project.DTOs;

import java.math.BigDecimal;

public class AccountResponseDTO {
    public String Iban;
    public BigDecimal balance;
    public String accountType;
    public BigDecimal absoluteLimit;
    public int userId;
}
