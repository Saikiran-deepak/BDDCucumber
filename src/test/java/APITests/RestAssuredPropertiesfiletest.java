package APITests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class RestAssuredPropertiesfiletest  {

    @Test
    public void testProperties() {

        Properties config = new Properties();

        try (FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/config.properties")) {

            config.load(fis);
            System.out.println(config.getProperty("baseURI"));

        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }
}
