package Scooter_Data.UI.NonStatic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitingBy_for_Selenium {

    public static WebDriverWait noConditions(WebDriver driver, int timeoutCount) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutCount));
    }

    public static WebElement conditions(WebDriver driver, int timeoutCount, By WanedElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutCount)).until(ExpectedConditions.visibilityOfElementLocated(WanedElement));
    }
}
