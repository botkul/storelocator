package com.causecode.storelocator.jersey.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ZipCode")
public class ZipCodeDto {
	private int zipcode;
	private String city;
	private String state;
	private float latitude;
	private float longitude;
	
	public ZipCodeDto(){}
	
	public ZipCodeDto(int zipcode,String city,String state,float latitude,float longitude){
		this.zipcode= zipcode;
		this.city= city;
		this.state= state;
		this.latitude= latitude;
		this.longitude= longitude;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
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
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}
