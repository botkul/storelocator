package com.causecode.storelocator.jaxrs.model;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.causecode.storelocator.jersey.dto.StoreDistanceDto;
import com.causecode.storelocator.jersey.dto.StoreDto;

@Entity
@Table(name="store")
@SqlResultSetMapping(name="StoreDistanceDtoMapping", classes={ @ConstructorResult(targetClass=StoreDistanceDto.class,
columns = {@ColumnResult(name="storeId"),@ColumnResult(name="storeName"),@ColumnResult(name="address"),@ColumnResult(name="city"),@ColumnResult(name="state"),@ColumnResult(name="zipcode"),@ColumnResult(name="distance")})}
)
@NamedNativeQuery(name="StorewithinXMiles",query="CALL sp_getStores	(:zipcode,:miles)",resultSetMapping="StoreDistanceDtoMapping")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="storeId")
	private int storeId;
	@Column(name="storeName")
	private String storeName;
	@Column(name="address")
	private String address;
	@Column(name="zipcode")
	private int zipcode;
	
	public Store(){}
	public Store(int storeId,String storeName,String address,int zipcode){
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
}
