package com.causecode.storelocator.jaxrs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.causecode.storelocator.jaxrs.model.Store;
import com.causecode.storelocator.jaxrs.model.ZipCode;
import com.causecode.storelocator.jersey.dto.StoreDistanceDto;
import com.causecode.storelocator.jersey.dto.StoreDto;
import com.causecode.storelocator.jersey.exception.DataNotFoundException;

@Repository
public class StoreDaoImpl implements StoreDao {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public void addStore(Store store) {
		sessionFactory.getCurrentSession().save(store);
	}

	@Transactional
	@Override
	public Store getStore(int storeId) {
		Store store=(Store)sessionFactory.getCurrentSession().get(Store.class, storeId);
		if(store==null)
			throw new DataNotFoundException("Store not found with StoreID="+storeId);
		return store;
	}

	@Transactional
	@Override
	public void updateStore(Store store) {
		sessionFactory.getCurrentSession().update(store);
	}

	@Transactional
	@Override
	public void removeStore(int storeId) {
		Store store=(Store)sessionFactory.getCurrentSession().get(Store.class, storeId);
		if(store==null)
			throw new DataNotFoundException("Data not found with StoreID="+storeId);
		
		sessionFactory.getCurrentSession().delete(store);
	}

	@Transactional
	@Override
	public List<Store> listStore() {
		return sessionFactory.getCurrentSession().createQuery("from Store").list();
	}

	@Transactional
	@Override
	public List<StoreDistanceDto> listAllStoresWithin_xMiles(int zipcode, float miles) {
		ZipCode objZipCode=(ZipCode)sessionFactory.getCurrentSession().get(ZipCode.class,zipcode);
		if(objZipCode==null)
			throw new DataNotFoundException("Data not found with ZipCode="+zipcode);
		Query query=sessionFactory.getCurrentSession().getNamedQuery("StorewithinXMiles")
									.setParameter("zipcode", zipcode)
									.setParameter("miles", miles);
		
		return query.list();
	}
}
