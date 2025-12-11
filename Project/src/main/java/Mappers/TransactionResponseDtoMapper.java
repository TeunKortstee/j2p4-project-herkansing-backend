package Mappers;

import Models.Transaction;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import Dtos.TransactionResponseDTO;

@Service
public class TransactionResponseDtoMapper implements Function<Transaction, TransactionResponseDTO> {

    @Override
    public TransactionResponseDTO apply(Transaction result) {
        return new TransactionResponseDTO(result.getTransactionId(), result.getAmount(),
                result.getDate(), result.getInitiatedBy(), result.getToAccount(), result.getFromAccount());
    }

}
