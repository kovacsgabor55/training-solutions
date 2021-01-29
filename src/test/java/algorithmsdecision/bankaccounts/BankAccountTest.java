package algorithmsdecision.bankaccounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    BankAccount bankAccount = new BankAccount("Fred", "123-324-123", 100);

    @Test
    public void testCreateBankAccount() {

        assertEquals(bankAccount.getAccountNumber(), "123-324-123");
        assertEquals(bankAccount.getBalance(), 100);

    }

    @Test
    public void testWithdraw() {
        bankAccount.withdraw(50);
        assertEquals(bankAccount.getBalance(), 50);
        assertEquals(bankAccount.withdraw(110), false);
        assertEquals(bankAccount.withdraw(20), true);
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(100);
        assertEquals(bankAccount.getBalance(), 200);
        assertEquals(bankAccount.deposit(20), true);

    }

}
