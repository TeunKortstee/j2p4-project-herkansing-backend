package Controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Dtos.AccountRequestDTO;
import Models.Account;
import Models.AccountType;
import Models.User;
import Services.AccountService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public ResponseEntity<?> createAccounts(@RequestBody AccountRequestDTO accountRequestDTO) {
        List<Account> accounts = new ArrayList<>();
        Account savingsAccount = Account.builder().balance(new BigDecimal(0)).accountType(AccountType.SAVINGS)
                .user(User.builder().userId(accountRequestDTO.userId).build()).build();
        Account checkingsAccount = Account.builder().balance(new BigDecimal(0)).accountType(AccountType.CHECKINGS)
                .user(User.builder().userId(accountRequestDTO.userId).build()).build();
        accounts.add(checkingsAccount);
        accounts.add(savingsAccount);
        return ResponseEntity.ok(this.accountService.createAccounts(accounts));
    }

    @GetMapping
    public ResponseEntity<?> getAccountsByIban(@RequestParam String Iban) {
        return ResponseEntity.ok(this.accountService.getAccountsByIban(Iban));
    }
}
