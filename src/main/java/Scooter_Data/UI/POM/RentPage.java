package Scooter_Data.UI.POM;

import Scooter_Data.UI.Static.ScooterColor_UI;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class RentPage {
    WebDriver driver;
    public static String orderNumber;

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    SelenideElement datePicker = $x(".//input[contains(@placeholder,'Когда')]");
    SelenideElement rentPeriodDropdownSelector = $(".Dropdown-arrow");
    List<SelenideElement> rentPeriodList = $$(".Dropdown-option").as("Collection days of rent");

    public void setRentPeriod(String rentPeriod) {
        for (SelenideElement selenideElement : rentPeriodList) {
            if (selenideElement.getText().equals(rentPeriod)) {
                selenideElement.click();
                break;
            }
        }
    }

    List<SelenideElement> ScooterColorList = $$(".Checkbox_Label__3wxSf");

    public void setScooterColor(ScooterColor_UI color) {
        for (SelenideElement selenideElement : ScooterColorList) {
            if (selenideElement.getAttribute("for").equalsIgnoreCase(color.toString())) {
                selenideElement.click();
                break;
            }
        }
    }

    SelenideElement commentInput = $x(".//input[contains(@placeholder,'Комментарий')]");
    SelenideElement orderCreateButton = $x("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(.,'Заказать')]");

    SelenideElement orderConfirmPopup = $(".Order_Modal__YZ-d3");

    public boolean isorderConfirmPopup() {
        return orderConfirmPopup.isDisplayed();
    }

    SelenideElement orderConfirmModal = $(".Order_ModalHeader__3FDaJ");
    SelenideElement orderConfirm_YES = $x(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(.,'Да')]");
    SelenideElement orderConfirm_NO = $x(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(.,'Нет')]");
    SelenideElement checkStatusButton = $x(".//div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(.,'Просмотреть статус')]");

    public void fillRentPage(String date, ScooterColor_UI color, String rentPeriod, String comment) {
        datePicker.setValue(date);
        rentPeriodDropdownSelector.click();
        setRentPeriod(rentPeriod);
        setScooterColor(color);
        this.commentInput.sendKeys(comment);
        orderCreateButton.click();
    }

    public void createRentOrder() {
        orderConfirmPopup.shouldBe(Condition.visible);
        orderConfirm_YES.click();
        orderNumber = orderConfirmModal.shouldBe(Condition.visible).$(".Order_Text__2broi").getText().replaceAll("[^\\d]", "");
        //checkStatus.click();
    }
}

