package model;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SportsDirectTest {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By KIDS_CATALOG_BTN = By.xpath(".//div[@title = 'Kids']");
    private final By KIDS_MENU = By.xpath(".//div[@class = 'swiper-wrapper']");
    private final By HOODIES_BTN = By.xpath(".//a[@href = '/kids/clothing/hoodies']");
    private final String SECTION = "Hoodies";

    @Test
    public void SportDirect() {

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("lv.sportsdirect.com");
        WebDriver browser = baseFunc.getBrowser();

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.presenceOfElementLocated(ACCEPT_COOKIES_BTN));

        WebElement acceptBtn = browser.findElement(ACCEPT_COOKIES_BTN);

        acceptBtn.click();

        WebElement kids_catalog = browser.findElement(KIDS_CATALOG_BTN);
        kids_catalog.click();

        WebElement menuBlock = browser.findElement(KIDS_MENU);
        List<WebElement> items = menuBlock.findElements(HOODIES_BTN);

        boolean isSectionFound = false;
        for (WebElement we : items) {
            if (we.getText().equals(SECTION)) {
                wait.until(ExpectedConditions.elementToBeClickable(we));
                isSectionFound = true;
                we.click();
                break;
            }
        }
    }
}