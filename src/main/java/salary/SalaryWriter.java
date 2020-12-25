package salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {
    List<String> salarys;

    public SalaryWriter(List<String> salarys) {
        this.salarys = salarys;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String item : salarys) {
                pw.print(item);
                pw.print(": ");
                if (item.startsWith("Dr.")) {
                    pw.println(500000);
                } else if (item.startsWith("Mr.") || item.startsWith("Mrs.")) {
                    pw.println(200000);
                } else {
                    pw.println(100000);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
