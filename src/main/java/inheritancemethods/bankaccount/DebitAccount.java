package inheritancemethods.bankaccount;

public class DebitAccount {
    private String accountNumber;
    private long balance;
    static final double COST = 3.0;
    static final long MIN_COST = 200;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final long costOfTransaction(long amount) {
        return 0;
    }

    public boolean transaction(long amount) {
        return false;
    }

    // az egyenleget nullázza le, túlköltés esetén
    public void balanceToZero() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }
}
