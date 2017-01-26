package com.causecode.storelocator.jaxrs.service;

import java.util.List;

import com.causecode.storelocator.jersey.dto.ZipCodeDto;

public interface ZipCodeService {
	void addZipCode(ZipCodeDto objZipCodeDto);
	ZipCodeDto getZipCode(int zipcode);
	void updateZipCode(ZipCodeDto objZipCodeDto);
	void removeZipCode(int zipcode);
	List<ZipCodeDto> listZipCodeDto();
}
