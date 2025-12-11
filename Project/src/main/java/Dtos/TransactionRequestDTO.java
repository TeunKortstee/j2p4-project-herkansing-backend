package Dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequestDTO {
    public BigDecimal amount;
    public LocalDate date;
    public int initiatedBy;
    public String toAccount;
    public String fromAccount;
}
