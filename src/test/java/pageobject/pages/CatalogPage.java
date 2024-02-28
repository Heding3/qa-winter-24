package pageobject.pages;

import org.openqa.selenium.By;
import pageobject.BaseFunc;

public class CatalogPage {
    private final By PRICE_FROM = By.id("attr-from-price");
    private final By PRICE_TO = By.id("attr-to-price");
    private final By FILTER_VALUE = By.xpath("./span[@class = 'catalog-taxons-filter-tools__active-filter']");
    private BaseFunc baseFunc;

    public CatalogPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void setPriceFilter(double priceFrom, double priceTo) {
        baseFunc.typeText(PRICE_FROM, String.valueOf(priceFrom));
        baseFunc.pressEnter(PRICE_FROM);

        baseFunc.waitForText(FILTER_VALUE, "€ no " + priceFrom);

        baseFunc.typeText(PRICE_TO, String.valueOf(priceTo));
        baseFunc.pressEnter(PRICE_TO);

        baseFunc.waitForText(FILTER_VALUE, "€ " + priceFrom + " - " + priceTo);
    }
}
