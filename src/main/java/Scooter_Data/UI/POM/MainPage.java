package Scooter_Data.UI.POM;


import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.exist;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private SelenideElement topOrderButton = $$(".Button_Button__ra12g").findBy(Condition.text("Заказать"));

    public void clickTopOrderButton() {
        topOrderButton.click();
    } // ����� ����� �� ������� ������

    private SelenideElement downOrderButton = $(".Home_FinishButton__1_cWm").$x("./button[text()='Заказать']");


    public void clickDownOrderButton() {
        Selenide.executeJavaScript("arguments[0].scrollIntoView();", downOrderButton);
        downOrderButton.click();
    }

    private SelenideElement orderStatusButton = $(".Header_Link__1TAG7");

    private SelenideElement orderStatusInput = $(".Input_Input__1iN_Z.Header_Input__xIoUq");
    private SelenideElement goButton = $(".Button_Button__ra12g.Header_Button__28dPO");

    public void clickOrderStatusButton() {
        orderStatusButton.click();
    }

    public void fillOrderStatusInput(String data) {
        orderStatusInput.setValue(data);
    }


    public void clickGoButton() {
        goButton.click();
    }

    private SelenideElement cookieButton = $(".App_CookieButton__3cvqF");

    public void clickCookieButton() {

        if (cookieButton.isDisplayed()) {
            cookieButton.click();
        }
    }

    private SelenideElement YandexLogo = $(".Header_LogoYandex__3TSOI");

    public void clickYandexLogo() {
        YandexLogo.click();
    }

    private SelenideElement scooterLogo = $(".Header_LogoScooter__3lsAR");
    public void clickScooterLogo()
    {
        scooterLogo.click();
    }

    public Boolean isScooterHeaderData()
    {
       return $(".Home_Header__iJKdX").shouldHave(text("Самокат на пару дней")).isDisplayed();
    }

    private SelenideElement questionsList = $(".Home_FAQ__3uVm4");

    public void scrollQuestionList() {
        Selenide.executeJavaScript("arguments[0].scrollIntoView();", questionsList);

    }

    public String[] getActualAnswers() {
        List<SelenideElement> answersList = $$(".accordion__item");
        String[] arrAnswersList = new String[answersList.size()];
        for (int i = 0; i < answersList.size(); i++) {
            answersList.get(i).click();
            arrAnswersList[i] = answersList.get(i).$x(".//p").shouldBe(exist).getText();
        }
        return arrAnswersList;
    }

}
