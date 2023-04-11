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
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class WrongDataRequestError extends BasePage_API {
	static Generator_JSON_courierData courierData;
	String json;

	public WrongDataRequestError(String json) {
		this.json = json;
	}

	@Parameterized.Parameters
	public static Object[][] paramInit()
	{
		courierData = new Generator_JSON_courierData();
		return new Object[][]
				{
						{String.format("{\"login\": \"%s1\",\"password\": \"%s\"}", courierData.getLogin(), courierData.getPassword())},
						{String.format("{\"login\": \"%s\",\"password\": \"%s1\"}", courierData.getLogin(), courierData.getPassword())},
				};
	}
	@Test
	@DisplayName("Получение 404 ошибке при некорректной паре логин/пароль")
	public void InvalidLogPassPaid()
	{
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
						.body(json)
						.when()
						.post(courierLogin);
		login.then().assertThat().statusCode(404).and().body("message", equalTo("Учетная запись не найдена"));

	}
}
