package Scooter_Data.API.RequestDeserializer;

public class Deserializer_courierLogin {
	String id;
	String message;

	public Deserializer_courierLogin(String id, String message) {
		this.id = id;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
}
