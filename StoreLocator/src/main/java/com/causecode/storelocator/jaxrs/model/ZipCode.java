package com.causecode.storelocator.jaxrs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zipcodes")
public class ZipCode {
	@Id
	@Column(name="zipcode")
	private int zipcode;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="latitude", precision=10, scale=2)
	private float latitude;
	@Column(name="longitude", precision=10, scale=2)
	private float longitude;
	
	public ZipCode(){}
	
	public ZipCode(int zipcode,String city,String state,float latitude,float longitude){
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
