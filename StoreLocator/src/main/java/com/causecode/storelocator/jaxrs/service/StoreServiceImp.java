package com.causecode.storelocator.jaxrs.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.causecode.storelocator.jaxrs.dao.StoreDao;
import com.causecode.storelocator.jaxrs.model.Store;
import com.causecode.storelocator.jersey.dto.StoreDistanceDto;
import com.causecode.storelocator.jersey.dto.StoreDto;

@Service
public class StoreServiceImp implements StoreService {
	@Autowired
	StoreDao storeDao;
	
	@Override
	public void addStore(StoreDto storeDto) {
		storeDao.addStore(newStore(storeDto));
	}

	@Override
	public StoreDto getStore(int storeId) {
		Store store=storeDao.getStore(storeId);
		return newStoreDto(store);
	}

	@Override
	public void updateStore(StoreDto storeDto) {
		storeDao.updateStore(newStore(storeDto));
	}

	@Override
	public void removeStore(int storeId) {
		storeDao.removeStore(storeId);
	}
	
	@Override
	public List<StoreDto> listStoreDto() {
		return listStore();
	}
	
	@Override
	public List<StoreDto> listStore() {
		List<StoreDto> stores=new ArrayList<StoreDto>();
		
		for(Store s : storeDao.listStore()){
			stores.add(newStoreDto(s));
		}
		return stores;
	}
	
	private StoreDto newStoreDto(Store store){
		return new StoreDto(store.getStoreId(),store.getStoreName(),store.getAddress(),store.getZipcode());
	}
	
	private Store newStore(StoreDto storeDto){
		return new Store(storeDto.getStoreId(),storeDto.getStoreName(),storeDto.getAddress(),storeDto.getZipcode());
	}

	@Override
	public List<StoreDistanceDto> listAllStoresWithin_xMiles(int zipcode, float miles) {
		return storeDao.listAllStoresWithin_xMiles(zipcode, miles);
	} 
}
