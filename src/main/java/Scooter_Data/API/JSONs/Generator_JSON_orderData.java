package Scooter_Data.API.JSONs;

import Scooter_Data.API.CommonData.ScooterColor_API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Generator_JSON_orderData {
	String firstName;
	String lastName;
	String address;
	String metroStation;
	String phone;
	int rentTime;
	String deliveryDate;
	String comment;
	String color;
	String orderJSON;

	public Generator_JSON_orderData(String firstName, String lastName, int metroStation, int rentTime, String comment, String color) {
		Random rnd = new Random();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = "Россия, Москва, Ленина, 12, 12, 12";
		this.metroStation = String.valueOf(metroStation);
		this.phone = "+7 " + rnd.nextInt(100,999) + " " + rnd.nextInt(100,999) + " " + rnd.nextInt(0,99) + " " + rnd.nextInt(0,99);
		this.rentTime = rentTime;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		this.deliveryDate = dtf.format(now);
		this.comment = comment;
		this.color = color;
	}

	public String getOrderJSON()
	{
		orderJSON = String.format("{\"firstName\": \"%s\", \"lastName\": \"%s\", \"address\": \"%s\", \"metroStation\": %s, \"phone\": \"%s\", \"rentTime\": %d, \"deliveryDate\": \"%s\", \"comment\": \"%s\", \"color\": [\"%s\"]}"
				,firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color	);
		return orderJSON;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getMetroStation() {
		return metroStation;
	}

	public String getPhone() {
		return phone;
	}

	public int getRentTime() {
		return rentTime;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public String getComment() {
		return comment;
	}

	public String getColor() {
		return color;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMetroStation(String metroStation) {
		this.metroStation = metroStation;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setRentTime(int rentTime) {
		this.rentTime = rentTime;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
