package BaseClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Core.DriverManager;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }
    
    
    
}