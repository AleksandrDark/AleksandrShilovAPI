package util;

import java.util.Properties;
import lombok.SneakyThrows;

public class PropertyReader {

    public static String getKey() {
        return PropertyReader.getProperties("properties/conf.properties").get("trelloKey").toString();
    }

    public static String getToken() {
        return PropertyReader.getProperties("properties/conf.properties").get("trelloToken").toString();
    }

    public static String getBaseUrl() {
        return PropertyReader.getProperties("properties/test.properties").get("BASE_URL").toString();
    }


    @SneakyThrows
    private static Properties getProperties(String path) {
        Properties properties = new Properties();
        properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(path));
        return properties;
    }
}
