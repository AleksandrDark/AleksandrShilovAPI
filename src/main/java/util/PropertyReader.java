package util;

import java.util.Properties;
import lombok.SneakyThrows;

public class PropertyReader {
    private static Properties prop = getProperties();

    public static String getKey() {
        return prop.get("trelloKey").toString();
    }

    public static String getToken() {
        return prop.get("trelloToken").toString();
    }

    public static String getBaseUrl() {
        return prop.get("BASE_URL").toString();
    }

    @SneakyThrows
    private static Properties getProperties() {
        Properties properties = new Properties();
        String path = "properties/conf.properties";
        properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(path));
        return properties;
    }
}
