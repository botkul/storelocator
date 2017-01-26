package com.causecode.storelocator.jaxrs.dao;

import java.util.List;

import com.causecode.storelocator.jaxrs.model.ZipCode;
import com.causecode.storelocator.jersey.dto.ZipCodeDto;

public interface ZipCodeDao {
	void addZipCode(ZipCode objzipcode);
	ZipCode getZipCode(int zipcode);
	void updateZipCode(ZipCode objzipcode);
	void removeZipCode(int zipcode);
	List<ZipCode> listZipCode();
}
