package Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public Optional<Account> getAccountsByIban(String Iban);
}
