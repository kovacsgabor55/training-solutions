package iofiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Installer {
    private String INSTALLFILE = "src/main/resources/install.txt";

    public void install(String targetDirectory) {
        Path target = Path.of(targetDirectory);
        Path installfile = Path.of(INSTALLFILE);
        if (!Files.exists(target) || !Files.isDirectory(target)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(INSTALLFILE))) {
            String fn;
            while ((fn = br.readLine()) != null) {
                if (fn.endsWith("/")) {
                    Files.createDirectories(Path.of(targetDirectory, fn));
                } else {
                    Files.copy(Path.of("src/main/resources/install/"), Path.of(targetDirectory, fn), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
