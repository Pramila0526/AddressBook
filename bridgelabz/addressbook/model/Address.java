package com.bridgelabz.addressbook.model;

public class Address {

	private String address;
	private String city;
	private String state;
	private int zip;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String toString() {
		return "Address [addressLocal=" + address + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
}
