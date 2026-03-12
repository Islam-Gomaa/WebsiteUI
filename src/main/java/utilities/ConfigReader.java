package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties config = new Properties();
    private static Properties envProperties = new Properties();

    static {

        try {

            // Load main configuration file
            FileInputStream configFile =
                    new FileInputStream("src/main/resources/Configuration.properties");

            config.load(configFile);

            // Read environment from command line first
            String env = System.getProperty("env");

            // If not provided, use default from config
            if (env == null) {
                env = config.getProperty("environment");
            }

            System.out.println("Running tests on environment: " + env);

            // Load environment file
            FileInputStream envFile =
                    new FileInputStream("src/main/resources/" + env + ".properties");

            envProperties.load(envFile);

        } catch (Exception e) {

            throw new RuntimeException("Failed to load configuration files", e);

        }

    }

    public static String get(String key) {

        String value = envProperties.getProperty(key);

        if (value == null) {
            value = config.getProperty(key);
        }

        if (value == null) {
            throw new RuntimeException("Key not found in properties: " + key);
        }

        return value;
    }
}