package com.causecode.storelocator.jersey.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Store")
public class StoreDto {
	private int storeId;
	private String storeName;
	private String address;
	private int zipcode;
	
	public StoreDto(){}
	
	public StoreDto(int storeId,String storeName,String address,int zipcode){
		this.storeId=storeId;
		this.storeName=storeName;
		this.address=address;
		this.zipcode=zipcode;
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
	
	@Override
	public String toString(){
		 return "[StoreId="+storeId+",StoreName="+ storeName+",Address="+ address+",ZipCode="+ zipcode+"]";
	}
}
