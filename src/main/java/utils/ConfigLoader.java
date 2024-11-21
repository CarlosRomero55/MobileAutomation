package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private Properties properties;

    public ConfigLoader() throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        properties.load(fis);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
