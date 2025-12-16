package Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import Models.Transaction;
import Models.User;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
    public List<Transaction> findTransactionsByUser(User user);

    public List<Transaction> findAllByIban(String Iban);
}
