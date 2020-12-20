package transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<BankAccount> accountList = new ArrayList<>();

    public void uploadListFromFile(String filePath) {
        Path accounts = Path.of(filePath);
        List<String> readed = null;
        try {
            readed = Files.readAllLines(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String item : readed) {
            String[] accs = item.split(";");
            accountList.add(new BankAccount(accs[0], accs[1], Double.parseDouble(accs[2])));
        }
    }

    public void makeTransactions(String filePath) {
        Path transactions = Path.of(filePath);
        List<String> readed = null;
        try {
            readed = Files.readAllLines(transactions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String item : readed) {
            for (BankAccount ba : accountList) {
                if (ba.getAccountNumber().equals(item.split(";")[0])) {
                    ba.setBalance(Double.parseDouble(item.split(";")[1]));
                }
            }
        }
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }
}
