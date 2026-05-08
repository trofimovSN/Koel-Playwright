package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties localProperties = new Properties();
    private static final Properties configProperties = new Properties();

    static {
        loadProperties(localProperties, "local.properties", false);
        loadProperties(configProperties, "config.properties", true);
    }

    private static void loadProperties(Properties props, String fileName, boolean isRequired) {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input != null) {
                props.load(input);
            } else if (isRequired) {
                throw new RuntimeException(fileName + " not found in resources!");
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error loading " + fileName, ex);
        }
    }

    public static String get(String key) {
        String value = localProperties.getProperty(key);
        if (value == null) {
            value = configProperties.getProperty(key);
        }
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found!");
        }
        return value;
    }
}