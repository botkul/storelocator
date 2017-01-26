package com.causecode.storelocator.jaxrs.service;

import java.util.List;

import com.causecode.storelocator.jaxrs.model.Store;
import com.causecode.storelocator.jersey.dto.StoreDistanceDto;
import com.causecode.storelocator.jersey.dto.StoreDto;

public interface StoreService {
	void addStore(StoreDto store);
	StoreDto getStore(int storeId);
	void updateStore(StoreDto store);
	void removeStore(int storeId);
	List<StoreDto> listStoreDto();
	List<StoreDto> listStore();
	List<StoreDistanceDto> listAllStoresWithin_xMiles(int zipcode, float miles);
}
