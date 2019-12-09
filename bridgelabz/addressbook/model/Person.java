package com.bridgelabz.addressbook.model;

public class Person {

	private String firstName;
	private String lastName;
	private Address addressObj;
	private Long mobileNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddressObj() {
		return addressObj;
	}

	public void setAddressObj(Address addressObj) {
		this.addressObj = addressObj;
	}

	public Long getMobile() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String toString() {
		return "Person [firstname=" + firstName + ", lastname=" + lastName + ", addressObj=" + addressObj + ", mobile number="
				+ mobileNumber + "]";
	}

}
