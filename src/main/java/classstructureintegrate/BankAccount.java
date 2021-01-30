package classstructureintegrate;

public class BankAccount {
    private final String accountNumber;
    private final String owner;
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

    public static void transfer(BankAccount accFrom, BankAccount accTo, int amount) {
        accFrom.withdraw(amount);
        accTo.deposit(amount);
    }

    public String getInfo() {
        return owner + " (" + accountNumber + "): " + balance + " Ft";
    }
}
