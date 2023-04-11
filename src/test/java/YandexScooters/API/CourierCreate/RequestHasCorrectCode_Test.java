package YandexScooters.API.CourierCreate;

import Scooter_Data.API.CommonData.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_courierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static Scooter_Data.API.CommonData.StaticData.courierCreate;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;

public class RequestHasCorrectCode_Test extends BasePage_API
{
	private static Generator_JSON_courierData courierData;
	@BeforeClass
	public static void SomeBeforeAll()
	{
		courierData = new Generator_JSON_courierData();
	}

	@Test
	@DisplayName("Корректное создание курьера возвращает код 201")
	public void Code201()
	{
		Response courier =
		given()
						.header("Content-type", "application/json")
						.and()
						.body(courierData.JSON_Register(1,1,1))
						.when()
						.post(courierCreate);
		courier.then().assertThat().statusCode(201);
	}
	@Test
	@DisplayName("Запрос без логина или пароля - код 400")
	public void Code400()
	{
		Response courier =
				given()
						.header("Content-type", "application/json")
						.and()
						.body(courierData.JSON_Register(0,1,1))
						.when()
						.post(courierCreate);
		courier.then().assertThat().statusCode(400);
	}
	@Test
	@DisplayName("Повторяющаяся пара логине-пароль - код 409")
	public void Code409()
	{
		Response courier =
				given()
						.header("Content-type", "application/json")
						.and()
						.body(courierData.JSON_Register(1,1,1))
						.when()
						.post(courierCreate);
		courier.then().assertThat().statusCode(409);
	}
}

