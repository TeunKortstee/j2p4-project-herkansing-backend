package Controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Dtos.TransactionRequestDTO;
import Models.Account;
import Models.Transaction;
import Models.User;
import Services.TransactionService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = new Transaction.Builder()
                .Amount(transactionRequestDTO.amount)
                .Date(LocalDate.now())
                .Initiator(User.builder().userId(transactionRequestDTO.initiatedBy).build())
                .Receiver(Account.builder().Iban(transactionRequestDTO.toAccount).build())
                .Sender(Account.builder().Iban(
                        transactionRequestDTO.fromAccount).build())
                .Build();
        return ResponseEntity.ok(this.transactionService.CreateTransaction(transaction));
    }

    @GetMapping
    public ResponseEntity<?> getTransactions() {
        return ResponseEntity.ok(this.transactionService.GetTransactions());
    }

    @GetMapping("/{Iban}")
    public ResponseEntity<?> getTransactionsByIban(@RequestParam String Iban) {
        return ResponseEntity.ok(this.transactionService.GetTransactionByIban(Iban));
    }
}
