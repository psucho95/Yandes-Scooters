package YandexScooters.API.CourierCreate;

import Scooter_Data.API.CommonData.BasePage_API;
import Scooter_Data.API.JSONs.Generator_JSON_courierData;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static Scooter_Data.API.CommonData.StaticData.courierCreate;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class NeedAllFieldsForRegister_Test extends BasePage_API {
	String json;

	public NeedAllFieldsForRegister_Test(String json) {
		this.json = json;
	}

	@Parameterized.Parameters
	public static Object[][] GettingSomeUsers() {
		Generator_JSON_courierData courierData = new Generator_JSON_courierData();
		return new Object[][]
				{
						{courierData.JSON_Register(0, 0, 0)},
						{courierData.JSON_Register(0, 1, 1)},
						{courierData.JSON_Register(0, 0, 1)},
						{courierData.JSON_Register(1, 0, 1)},
						{courierData.JSON_Register(1, 0, 0)},
						{courierData.JSON_Register(0, 1, 0)},
				};

	}

	@Test
	@DisplayName("Проверка на невозможость создания клиента с неполным пулом данных")
	public void NeedAllFields()
	{
		Response courier =
		given()
						.header("Content-type", "application/json")
						.and()
						.body(json)
						.when()
						.post(courierCreate);
		courier.then().assertThat().statusCode(400).body("message", equalTo("Недостаточно данных для создания учетной записи"));
	}
}
