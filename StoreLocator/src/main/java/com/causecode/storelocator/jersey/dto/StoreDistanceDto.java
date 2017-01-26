package com.causecode.storelocator.jersey.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StoreDistanceDto {
	private int storeId;
	private String storeName;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	private double distance;
	
	public StoreDistanceDto(){}
	
	public StoreDistanceDto(int storeId,String storeName,String address,String city, String state, int zipcode, double distance){
		this.storeId=storeId;
		this.storeName=storeName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zipcode=zipcode;
		this.distance=distance;
	}
	public StoreDistanceDto(int distance){
		this.distance=distance;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
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

	@Override
	public String toString(){
		 return "[StoreId="+storeId+",StoreName="+ storeName+",Address="+ address+",City="+city+",State="+state+",ZipCode="+ zipcode+",Distance="+distance+"]";
	}
}
