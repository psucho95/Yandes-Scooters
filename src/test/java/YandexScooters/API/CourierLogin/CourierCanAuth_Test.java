package YandexScooters.API.CourierLogin;

import Scooter_Data.API.CommonData.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_courierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static Scooter_Data.API.CommonData.StaticData.courierCreate;
import static Scooter_Data.API.CommonData.StaticData.courierLogin;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CourierCanAuth_Test extends BasePage_API {

	@Test
	@DisplayName("Курьер успешно авторизовывается")
	public void CourierCanAuth_True()
	{
		Generator_JSON_courierData courierData = new Generator_JSON_courierData();
		given()
				.header("Content-type", "application/json")
				.and()
				.body(courierData.JSON_Register(1,1,1))
				.when()
				.post(courierCreate);

		Response login =
		given()
						.header("Content-type", "application/json")
						.and()
						.body(courierData.JSON_Login(1,1))
						.when()
						.post(courierLogin);
		int sc = login.statusCode();
		login.then().assertThat().body("id", notNullValue()).and().statusCode(200);
	}
}
