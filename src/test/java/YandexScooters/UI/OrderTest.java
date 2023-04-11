package YandexScooters.UI;

import Scooter_Data.UI.Data.PersonData;
import Scooter_Data.UI.POM.MainPage;
import Scooter_Data.UI.POM.OrderPage;
import Scooter_Data.UI.POM.RentPage;
import Scooter_Data.UI.Static.BasePage;
import Scooter_Data.UI.Static.ScooterColor_UI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BasePage {
    private String name;
    private String surname;
    private String address;
    private String station;
    private String phone;
    private String date;
    private String period;
    private String color;
    private String comment;

    public OrderTest(String name, String surname, String address, String station, String phone, String date, String period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]
                {
                        {"Лариса", "Ли", "город Ташкент", "Бульвар Рокоссовского", "+99899999999", "27.01.2023", "двое суток", "black", "хочу бургер"},
                        {"Володя", "Кит", "город Псков", "Черкизовская", "+7688999999", "21.05.2023", "сутки", "grey", "хочу колы"}
                };
    }

    @Test
    public void correctOrder_orderTopButton_true() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        objMainPage.clickTopOrderButton();

        PersonData Ilya = new PersonData(name, surname, address, station, phone);
        OrderPage order1 = new OrderPage(driver);

        order1.fillOrderForm(Ilya);
        order1.clickNextButton();

        RentPage rent1 = new RentPage(driver);
        rent1.fillRentPage(date, ScooterColor_UI.BLACK, period, comment);
        rent1.createRentOrder();
        assertTrue("Order number isn't correct", rent1.isorderConfirmPopup());    }
    @Test
    public void correctOrder_orderDownButton_true() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        objMainPage.clickDownOrderButton();

        PersonData Ilya = new PersonData(name, surname, address, station, phone);
        OrderPage order1 = new OrderPage(driver);

        order1.fillOrderForm(Ilya);
        order1.clickNextButton();

        RentPage rent1 = new RentPage(driver);
        rent1.fillRentPage(date, ScooterColor_UI.GREY, period, comment);
        rent1.createRentOrder();
        assertTrue("Order number isn't correct", rent1.isorderConfirmPopup());
    }
}
