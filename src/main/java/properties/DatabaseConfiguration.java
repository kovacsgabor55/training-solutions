package properties;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class DatabaseConfiguration {
    private Properties properties;

    public DatabaseConfiguration(File file) {
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
        ) {
            load(fileInputStream);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    private Properties load(InputStream inputStream) {
        properties = new Properties();
        try (
                InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        ) {
            properties.load(reader);
            return properties;
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot read properties file from inputstream", ioe);
        }
    }

    public DatabaseConfiguration() {
        try (
                InputStream resource = DatabaseConfiguration.class.getResourceAsStream("/db.properties");
        ) {
            load(resource);
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot read file from classpath", ioe);
        }
    }

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }
}
