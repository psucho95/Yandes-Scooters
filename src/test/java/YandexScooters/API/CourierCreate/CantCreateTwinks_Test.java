package YandexScooters.API.CourierCreate;

import Scooter_Data.API.CommonData.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_courierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static Scooter_Data.API.CommonData.StaticData.courierCreate;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CantCreateTwinks_Test extends BasePage_API {
	protected static Generator_JSON_courierData courierData;
	@Before
	public void someInit()
	{
		courierData = new Generator_JSON_courierData();
		given()
				.header("Content-type", "application/json")
				.and()
				.body(courierData.JSON_Register(1,1,1))
				.when()
				.post(courierCreate);
	}
	@Test
	@DisplayName("Невозможность создания 2 одинаковых курьеров")
	public void  CourierCreating_CanCreateTwinks_FALSE()
	{

		Response courier =
				given()
						.header("Content-type", "application/json")
						.and()
						.body(courierData.JSON_Register(1,1,1))
						.when()
						.post(courierCreate);
		courier.then().assertThat().body("code",equalTo(409)).body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
	}
}
