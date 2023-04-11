package Scooter_Data.UI.POM;

import Scooter_Data.UI.Data.PersonData;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private SelenideElement nameInput = $x("//input[contains(@placeholder,'Имя')]");

    public void setNameInput(String name) {
        nameInput.setValue(name);
    }

    private SelenideElement surnameInput = $x("//input[contains(@placeholder,'Фамилия')]");

    public void setSurnameInput(String surname) {
        surnameInput.setValue(surname);
    }

    private SelenideElement deliveryAdressInput = $x("//input[contains(@placeholder,'Адрес')]");

    public void setDeliveryAdressInput(String deliveryAdress) {
        deliveryAdressInput.sendKeys(deliveryAdress);
    }

    private SelenideElement stationInput = $(".select-search__input");
    private List<SelenideElement> listStationDropdown = $$(".select-search__row");


    public void setStation(String stationName) {
        stationInput.click();
        stationInput.setValue(stationName);
        for (SelenideElement selenideElement : listStationDropdown) {

            if (selenideElement.getText().equals(stationName)) {
                selenideElement.click();
                break;
            }

        }

    }

    private SelenideElement phoneInput = $x("//input[contains(@placeholder,'Телефон')]");

    public void setPhoneInput(String phone) {
        phoneInput.setValue(phone);
    }

    private SelenideElement nextButton = $(".Button_Button__ra12g.Button_Middle__1CSJM");

    public void clickNextButton() {
        nextButton.click();
    }

    public void fillOrderForm(PersonData order) {
        setNameInput(order.getName());
        setSurnameInput(order.getSurname());
        setDeliveryAdressInput(order.getAddress());
        setStation(order.getStation());
        setPhoneInput(order.getPhone());
    }


}
