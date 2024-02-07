package pageobject;

import org.junit.jupiter.api.Test;
import pageobject.pages.HomePage;

public class InternetShopPagesTest {
    @Test
    public void testOnPages() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("1a.lv");

        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
//        homePage.selectMenuItem("Instrumenti");
    }
}
