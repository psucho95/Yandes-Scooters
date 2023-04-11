package Scooter_Data.API.RequestDeserializer;

public class Deserializer_courierCreate {
	String ok;
	String message;

	public Deserializer_courierCreate(String ok, String message) {
		this.ok = ok;
		this.message = message;
	}

	public String getOk() {
		return ok;
	}

	public String getMessage() {
		return message;
	}
}

