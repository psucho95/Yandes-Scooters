package YandexScooters.API.CourierCreate;

import Scooter_Data.API.CommonData.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_courierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static Scooter_Data.API.CommonData.StaticData.courierCreate;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestHasCorrectMessage_Test extends BasePage_API {

	@Test
	@DisplayName("Повторяющаяся пара логине-пароль - код 409")
	public void requestGetCorrectMessage()
	{
		Generator_JSON_courierData courierData = new Generator_JSON_courierData();
		Response courier =
				given()
						.header("Content-type", "application/json")
						.and()
						.body(courierData.JSON_Register(1, 1, 1))
						.when()
						.post(courierCreate);
		courier.then().assertThat().body("ok",equalTo(true));
	}
}
