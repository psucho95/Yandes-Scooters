package YandexScooters.UI;

import Scooter_Data.UI.POM.MainPage;
import Scooter_Data.UI.Static.BasePage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static junit.framework.TestCase.assertTrue;

public class HomePageRedirect extends BasePage {
    @Test
    public void HomePageClickRedirect_true() {
        open("https://qa-scooter.praktikum-services.ru/order");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickScooterLogo();
        assertTrue("Has no Header in page", mainPage.isScooterHeaderData());
    }
}
