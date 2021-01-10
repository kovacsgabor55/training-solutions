package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {
    public void saveTransactions(Path path, List<Transaction> transactionList) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Transaction item : transactionList) {
                zos.putNextEntry(new ZipEntry(Long.toString(item.getId())));
                zos.write(item.getTime().toString().getBytes());
                zos.write('\n');
                zos.write(item.getAccount().getBytes());
                zos.write('\n');
                zos.write(Double.toString(item.getAmount()).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
