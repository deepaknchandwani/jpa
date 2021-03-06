package com.deepakchandwani.jpa.common.Z2;
 

import javax.persistence.Embeddable;

@Embeddable
public class AddressZ2 {

	private String area;
	private String city;
	private String pincode;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
