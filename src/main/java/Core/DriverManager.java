package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void init() {

    String browser = ConfigReader.get("browser");

    switch (browser.toLowerCase()) {

        case "edge":
            System.setProperty(
                "webdriver.edge.driver",
                "C:/Users/kiran/Drivers/edgedriver_win64/msedgedriver.exe"
            );
            driver.set(new EdgeDriver());
            break;

        case "chrome":
        default:
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            break;
    }

    getDriver().manage().window().maximize();
}

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quit() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}