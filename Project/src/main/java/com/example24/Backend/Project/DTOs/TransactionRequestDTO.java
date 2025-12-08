package com.example24.Backend.Project.DTOs;

import java.time.LocalDate;

public class TransactionRequestDTO {
    public Double amount;
    public LocalDate date;
    public int initiatedBy;
    public int toAccount;
    public int fromAccount;
}
