package utils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartActions {

    private WebDriver driver;
    private WebDriverWait wait;

    public SmartActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // =========================
    // ✅ SAFE FILL
    // =========================
    public void safeFill(By locator, String value, String intent) {

        try {
            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            scrollToCenter(el);
            el.clear();
            el.sendKeys(value);
            return;

        } catch (Exception e) {
            System.out.println("Primary fill failed, trying intent...");
        }

        try {
            WebElement el = findInputByIntent(intent);

            scrollToCenter(el);
            el.clear();
            el.sendKeys(value);
            return;

        } catch (Exception e) {
            throw new RuntimeException("Unable to fill: " + intent);
        }
    }

    // =========================
    // ✅ SAFE CLICK (Playwright-like)
    // =========================
    public void safeClick(By locator, String intent) {

        // 1️⃣ Primary locator
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));

            scrollToCenter(el);
            el.click();
            System.out.println("✅ Clicked using locator");
            return;

        } catch (Exception e) {
            System.out.println("Primary failed, trying intent...");
        }

        // 2️⃣ Intent fallback (STRICT - only clickable elements)
        try {
            WebElement el = findClickableByIntent(intent);

            scrollToCenter(el);
            wait.until(ExpectedConditions.elementToBeClickable(el));

            el.click();
            System.out.println("✅ Clicked using intent");
            return;

        } catch (Exception e) {
            System.out.println("Intent failed...");
        }

        throw new RuntimeException("Unable to click: " + intent);
    }

    // =========================
    // 🔥 FIND CLICKABLE BY INTENT
    // =========================
    private WebElement findClickableByIntent(String intent) {

//        String xpath =
//            "//button[normalize-space()='" + intent + "'] | " +
//            "//button[contains(normalize-space(.),'" + intent + "')] | " +
//            "//input[@type='submit' and contains(@value,'" + intent + "')]";
    	
        String xpath =
                "//button[normalize-space()='" + intent + "'] | " +
                "//button[contains(normalize-space(.),'" + intent + "')] | " +
                "//input[@type='submit' and contains(@value,'" + intent + "')] | " +
                "//a[contains(normalize-space(.),'" + intent + "')] | " +
                "//*[@aria-label='" + intent + "'] | " +
                "//*[@role='button' and contains(.,'" + intent + "')]";

        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    // =========================
    // 🔥 FIND INPUT BY INTENT
    // =========================
    private WebElement findInputByIntent(String intent) {

        String xpath =
            "//input[contains(@placeholder,'" + intent + "')] | " +
            "//input[contains(@name,'" + intent.toLowerCase() + "')]";

        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    // =========================
    // 🔧 SCROLL CENTER (Playwright style)
    // =========================
    private void scrollToCenter(WebElement el) {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center'});", el
        );
    }

    // =========================
    // 🔧 JS CLICK (fallback)
    // =========================
    private void jsClick(WebElement el) {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", el
        );
    }

    // =========================
    // 🔧 OVERLAY HANDLER
    // =========================
    private void waitForOverlayToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector(".loader, .overlay, .spinner")
            ));
        } catch (Exception ignored) {}
    }
}