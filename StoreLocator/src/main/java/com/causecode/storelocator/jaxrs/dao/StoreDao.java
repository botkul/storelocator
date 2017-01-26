package com.causecode.storelocator.jaxrs.dao;

import java.util.List;

import com.causecode.storelocator.jaxrs.model.Store;
import com.causecode.storelocator.jersey.dto.StoreDistanceDto;
import com.causecode.storelocator.jersey.dto.StoreDto;

public interface StoreDao {
	void addStore(Store store);
	Store getStore(int storedId);
	void updateStore(Store store);
	void removeStore(int storeId);
	List<Store> listStore();
	List<StoreDistanceDto> listAllStoresWithin_xMiles(int zipcode, float miles);
}
