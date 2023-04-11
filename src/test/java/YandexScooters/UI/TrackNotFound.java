package YandexScooters.UI;

import Scooter_Data.UI.NonStatic.WaitingBy;
import Scooter_Data.UI.POM.MainPage;
import Scooter_Data.UI.POM.OrderTrackPage;
import Scooter_Data.UI.Static.BasePage;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class TrackNotFound extends BasePage {
    @Test
    public void trackNotFoundTrue()
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderStatusButton();
        mainPage.fillOrderStatusInput("555");
        mainPage.clickGoButton();
        OrderTrackPage orderTrackPage = new OrderTrackPage(driver);
        assertTrue("Not-found logo isn't exist", orderTrackPage.checkNotFoundPic());
    }
}
