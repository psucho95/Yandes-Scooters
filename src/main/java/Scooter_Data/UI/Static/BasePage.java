package Scooter_Data.UI.Static;


import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class BasePage {
    protected WebDriver driver;


    @Before
    public void runBeforeEveryTest() {

//        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//        String Firefoxdriverpath = "C:\\WebDriver\\bin\\geckodriver.exe";
//        System.setProperty("selenide.browser", "firefox");
        open("https://qa-scooter.praktikum-services.ru/");
        driver = getWebDriver();
    }
}
