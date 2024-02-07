package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseFunc {
    private WebDriver browser;

    public BaseFunc() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    public void openURL (String url) {
        if (!url.startsWith("http://") && !url.startsWith("https")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public WebDriver getBrowser() {
        return browser;
    }
}