package com.causecode.storelocator.jaxrs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.causecode.storelocator.jaxrs.model.ZipCode;
import com.causecode.storelocator.jersey.dto.ZipCodeDto;
import com.causecode.storelocator.jersey.exception.DataNotFoundException;

@Repository
public class ZipCodeDaoImpl implements ZipCodeDao {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public void addZipCode(ZipCode objzipcode) {
		sessionFactory.getCurrentSession().save(objzipcode);
	}

	@Transactional
	@Override
	public ZipCode getZipCode(int zipcode) {
		ZipCode objZipCode=(ZipCode)sessionFactory.getCurrentSession().get(ZipCode.class, zipcode);
		if(objZipCode==null)
			throw new DataNotFoundException("Data not found with ZipCode="+zipcode);
		
		return objZipCode;
	}

	@Transactional
	@Override
	public void updateZipCode(ZipCode objzipcode) {
		sessionFactory.getCurrentSession().update(objzipcode);
	}

	@Transactional
	@Override
	public void removeZipCode(int zipcode) {
		ZipCode objZipCode=(ZipCode)sessionFactory.getCurrentSession().get(ZipCode.class, zipcode);
		if(objZipCode==null)
			throw new DataNotFoundException("Data not found with ZipCode="+zipcode);
		
		sessionFactory.getCurrentSession().delete(objZipCode);
	}

	@Transactional
	@Override
	public List<ZipCode> listZipCode() {
		return sessionFactory.getCurrentSession().createQuery("from ZipCode").list();
		//return sessionFactory.getCurrentSession().createQuery("Select mew ZipCodeDto(zipcode,city,state,latitude,longitude) from zipcodes").list();
	}
}
