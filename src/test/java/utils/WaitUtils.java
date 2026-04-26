//package utils;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import Core.DriverManager;
//
//public class WaitUtils {
//
//    public static WebElement waitForVisible(By locator) {
//        WebDriverWait wait = new WebDriverWait(
//            DriverManager.getDriver(), Duration.ofSeconds(10)
//        );
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//}