package Scooter_Data.UI.POM;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class OrderTrackPage {
    WebDriver driver;

    public OrderTrackPage(WebDriver driver) {
        this.driver = driver;
    }

    private SelenideElement notFoundPic = $(".Track_NotFound__6oaoY");

    public Boolean checkNotFoundPic() {
        return notFoundPic.isDisplayed();
    }

}
