package Scooter_Data.UI.POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class YandexMainPage {
    WebDriver driver;

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
    }

    private SelenideElement ZenLocator = $(".zen-ui-generic-svg").as("ZenLogo");

    public boolean isZenLocator() {
       return ZenLocator.isDisplayed();
    }


}
