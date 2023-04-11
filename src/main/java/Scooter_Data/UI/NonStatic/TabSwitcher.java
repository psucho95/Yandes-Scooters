package Scooter_Data.UI.NonStatic;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class TabSwitcher {
    public static void switchTo(WebDriver driver, int tabNum) {
        ArrayList<String> Tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(tabNum - 1));
    }
}
