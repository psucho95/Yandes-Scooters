package Scooter_Data.API.RequestDeserializer;

public class Deserializer_courierDelete {
	String ok;
	String message;

	public Deserializer_courierDelete(String ok, String message) {
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
