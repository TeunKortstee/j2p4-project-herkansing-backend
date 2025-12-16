package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Dtos.AccountResponseDTO;
import Mappers.AccountResponseDtoMapper;
import Models.Account;
import Models.User;
import Repositories.AccountRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountServiceJpa implements AccountService {
    private final AccountRepository repository;
    private final AccountResponseDtoMapper mapper;

    @Override
    public AccountResponseDTO createAccount(Account account) {
        account = repository.save(account);
        return mapper.accountToAccountResponseDTO(account);
    }

    @Override
    public List<AccountResponseDTO> createAccounts(List<Account> accounts) {
        List<AccountResponseDTO> responses = new ArrayList<AccountResponseDTO>();
        for (Account account : accounts) {
            responses.add(this.createAccount(account));
        }
        return responses;
    }

    @Override
    public List<AccountResponseDTO> getAccountsByIban(String Iban) {
        Optional<Account> accounts = repository.getAccountsByIban(Iban);
        return accounts.stream().map(result -> mapper.accountToAccountResponseDTO(result)).toList();
    }

    @Override
    public List<AccountResponseDTO> getUserAccounts(User user) {
        List<Account> accounts = this.repository.getAccountsByUser(user);
        return accounts.stream().map(result -> this.mapper.accountToAccountResponseDTO(result)).toList();
    }

}
