package pageobject;

import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

// vzaimodejstvie s brauzerom

public class BaseFunc {

    private WebDriver browser;
    private WebDriverWait wait;

    public BaseFunc() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        browser = new ChromeDriver(options);
        browser.manage().window().maximize();

        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }

    public void openURL(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https")) {
            url = "http://" + url;
        }

        browser.get(url);
    }

    public void click(By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public List<WebElement> findElements(By locator) {
        return browser.findElements(locator);
    }

    public void scrollToElement(WebElement we) {
        JavascriptExecutor executor = (JavascriptExecutor) browser;
        executor.executeScript("arguments[0].scrollIntoView(true);", we);
        executor.executeScript("window.scrollBy(0, 500);");
    }
}

