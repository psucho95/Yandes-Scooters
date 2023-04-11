package YandexScooters.API.OrderCreate;

import Scooter_Data.API.CommonData.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_orderData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static Scooter_Data.API.CommonData.StaticData.createOrder;
import static io.restassured.RestAssured.given;

public class CanCreateOrder extends BasePage_API {
	@Test
	@DisplayName("Заказ создаётся корректно")
	public void CanCreateOrder_True()
	{
		Generator_JSON_orderData orderData = new Generator_JSON_orderData("Илья","Кондрашов", 5, 3, "Всё для меня", "BLACK, GREY");

		Response order =
		given()
						.header("Content-type", "application/json")
						.and()
						.body(orderData.getOrderJSON())
						.when()
						.post(createOrder);
	}
}
