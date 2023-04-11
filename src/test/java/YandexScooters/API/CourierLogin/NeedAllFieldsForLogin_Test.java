package YandexScooters.API.CourierLogin;

import Scooter_Data.API.CommonData.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_courierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static Scooter_Data.API.CommonData.StaticData.courierCreate;
import static Scooter_Data.API.CommonData.StaticData.courierLogin;
import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class NeedAllFieldsForLogin_Test extends BasePage_API {
	static Generator_JSON_courierData courierData;
	static String finalJson;

	public NeedAllFieldsForLogin_Test(String json)
	{
		this.finalJson = json;
	}
	@Parameterized.Parameters
	public static Object[][] someData() {
		courierData = new Generator_JSON_courierData();
		return new Object[][]
				{
						{courierData.JSON_Login(1, 0)},
						{courierData.JSON_Login(0, 1)},
				};
	}

	@Test
	@DisplayName("Для авторизации необходимы все поля")
	public void NeedAllFieldForLogin_True() {
		given()
				.header("Content-type", "application/json")
				.and()
				.body(courierData.JSON_Register(1, 1, 1))
				.when()
				.post(courierCreate);

		Response login =
				given()
						.header("Content-type", "application/json")
						.and()
						.body(finalJson)
						.when()
						.post(courierLogin);
		login.then().assertThat().statusCode(400);
	}
}
