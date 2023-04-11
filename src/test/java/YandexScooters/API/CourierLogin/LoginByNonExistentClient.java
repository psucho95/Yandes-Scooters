package YandexScooters.API.CourierLogin;

import Scooter_Data.API.CommonData.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_courierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static Scooter_Data.API.CommonData.StaticData.courierLogin;
import static io.restassured.RestAssured.given;

public class LoginByNonExistentClient extends BasePage_API {
	@Test
	@DisplayName("Ошибка при авторизации несуществующим клиентом")
	public void LoginByNonExistentClient_False()
	{
		Generator_JSON_courierData courierData = new Generator_JSON_courierData();

		Response login =
		given()
						.header("Content-type", "application/json")
						.and()
						.body(courierData.JSON_Login(1,1))
						.when()
						.post(courierLogin);
		login.then().assertThat().statusCode(404);
	}
}
