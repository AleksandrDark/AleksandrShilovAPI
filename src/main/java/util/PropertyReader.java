package util;

import java.util.Properties;
import lombok.SneakyThrows;

public class PropertyReader {

    @SneakyThrows
    public static Properties getProperties() {
        Properties properties = new Properties();
        String propertyFileName = "conf.properties";
        properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(propertyFileName));
        return properties;
    }
}
