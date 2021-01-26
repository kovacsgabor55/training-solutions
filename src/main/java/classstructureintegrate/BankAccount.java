package classstructureintegrate;
import org.jetbrains.annotations.NotNull;
public class BankAccount {
    private String accountNumber;
    private String owner;
    private int balance;

    public BankAccount(String accountNumber, String owner, int balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public static void transfer(@NotNull BankAccount accFrom, BankAccount accTo, int amount) {
        accFrom.withdraw(amount);
        accTo.deposit(amount);
    }

    public String getInfo() {
        return owner + " (" + accountNumber + "): " + balance + " Ft";
    }
}
