package model;

import org.junit.jupiter.api.Test;

public class SportsDirectsPageTest {
    @Test
    public void testOnPages() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openURL("lv.sportsdirect.com");
    }
}
