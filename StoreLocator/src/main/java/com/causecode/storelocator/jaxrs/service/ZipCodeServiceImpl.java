package com.causecode.storelocator.jaxrs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.causecode.storelocator.jaxrs.dao.ZipCodeDao;
import com.causecode.storelocator.jaxrs.model.Store;
import com.causecode.storelocator.jaxrs.model.ZipCode;
import com.causecode.storelocator.jersey.dto.StoreDto;
import com.causecode.storelocator.jersey.dto.ZipCodeDto;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {
	@Autowired
	ZipCodeDao zipCodeDao;
	
	@Override
	public void addZipCode(ZipCodeDto objZipCodeDto) {
		zipCodeDao.addZipCode(newZipCode(objZipCodeDto));
	}

	@Override
	public ZipCodeDto getZipCode(int zipcode) {
		ZipCode objZipCode=zipCodeDao.getZipCode(zipcode);
		return newZipCodeDto(objZipCode);
	}

	@Override
	public void updateZipCode(ZipCodeDto objZipCodeDto) {
		zipCodeDao.updateZipCode(newZipCode(objZipCodeDto));
	}

	@Override
	public void removeZipCode(int zipcode) {
		zipCodeDao.removeZipCode(zipcode);
	}

	@Override
	public List<ZipCodeDto> listZipCodeDto() {
		List<ZipCodeDto> zipcodes=new ArrayList<>();
		for(ZipCode z : zipCodeDao.listZipCode()){
			zipcodes.add(newZipCodeDto(z));
		}
		return zipcodes;
	}
	
	private ZipCode newZipCode(ZipCodeDto zipCodeDto){
		return new ZipCode(zipCodeDto.getZipcode(),zipCodeDto.getCity(),zipCodeDto.getState(),zipCodeDto.getLatitude(),zipCodeDto.getLongitude());
	}
	private ZipCodeDto newZipCodeDto(ZipCode objzipCode){
		return new ZipCodeDto(objzipCode.getZipcode(),objzipCode.getCity(),objzipCode.getState(),objzipCode.getLatitude(),objzipCode.getLongitude());
	} 
}
