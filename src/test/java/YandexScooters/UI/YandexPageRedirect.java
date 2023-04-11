package YandexScooters.UI;

import Scooter_Data.UI.NonStatic.TabSwitcher;
import Scooter_Data.UI.POM.MainPage;
import Scooter_Data.UI.POM.YandexMainPage;
import Scooter_Data.UI.Static.BasePage;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class YandexPageRedirect extends BasePage {
    @Test
    public void YandexClickRedirect_true() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickYandexLogo();
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        TabSwitcher.switchTo(driver,2);
        assertTrue("Has no Header in page",yandexMainPage.isZenLocator());
    }
}
