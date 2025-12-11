package Services;

import java.util.List;

import Dtos.TransactionResponseDTO;
import Mappers.TransactionResponseDtoMapper;
import Models.Transaction;
import Repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransactionServiceJpa implements TransactionService {
    private final TransactionRepository repository;
    private final TransactionResponseDtoMapper mapper;

    @Override
    public TransactionResponseDTO CreateTransaction(Transaction transaction) {
        transaction = this.repository.save(transaction);
        return mapper.apply(transaction);
    }

    @Override
    public List<TransactionResponseDTO> GetTransactions() {
        List<Transaction> transactions = repository.findAll();
        return transactions.stream()
                .map(result -> mapper.apply(result))
                .toList();
    }

    @Override
    public List<TransactionResponseDTO> GetTransactionByIban(String Iban) {
        List<Transaction> transactions = repository.findAllByIban(Iban);
        return transactions.stream().map(result -> mapper.apply(result)).toList();
    }

}
