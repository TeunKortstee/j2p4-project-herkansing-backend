package Services;

import java.util.List;
import java.util.Optional;

import Dtos.AccountResponseDTO;
import Models.Account;
import Models.User;

public interface AccountService {
    public AccountResponseDTO createAccount(Account account);

    public List<AccountResponseDTO> createAccounts(List<Account> Account);

    public List<AccountResponseDTO> getAccountsByIban(String Iban);

    public List<AccountResponseDTO> getUserAccounts(User user);
}
