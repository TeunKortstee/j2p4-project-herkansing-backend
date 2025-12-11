package Services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import Dtos.TransactionResponseDTO;
import Models.Transaction;

public interface TransactionService {
    public TransactionResponseDTO CreateTransaction(Transaction transaction);

    public List<TransactionResponseDTO> GetTransactions();

    public List<TransactionResponseDTO> GetTransactionByIban(String Iban);
}
