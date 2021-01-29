package algorithmsdecision.bankaccounts;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionExecutorTest {
    List<BankAccount> accounts = Arrays.asList(
            new BankAccount("Fred", "123-324-123", 100),
            new BankAccount("Kate", "133-324-123", 2000),
            new BankAccount("Mary", "143-324-123", 90)
    );

    List<Transaction> transactions = Arrays.asList(
            new Transaction("123-324-123", TransactionOperation.CREDIT, 2000, LocalDateTime.MIN),
            new Transaction("133-324-123", TransactionOperation.DEBIT, 200, LocalDateTime.MIN),
            new Transaction("143-324-123", TransactionOperation.DEBIT, 2000, LocalDateTime.MIN)
    );

    TransactionExecutor test = new TransactionExecutor();

    @Test
    public void testExecuteBankAccountCredit() {

        test.executeTransactions(transactions, accounts);
        assertEquals(accounts.get(0).getBalance(), 2100);

    }

    @Test
    public void testExecuteBankAccountDebitWithDrawOk() {

        test.executeTransactions(transactions, accounts);
        assertEquals(accounts.get(1).getBalance(), 1800);

    }

    @Test
    public void testExecuteBankAccountDebitWithDrawNotOk() {

        test.executeTransactions(transactions, accounts);
        assertEquals(accounts.get(2).getBalance(), 90);

    }
}
