package com.mahendra.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mahendra.entities.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {

	@PersistenceContext 
	private EntityManager em;
	
	
	public Country findById(String code) {
		return em.find(Country.class, code);
	}

	public List<Country> findByRegion(Integer regionId) {
		Query q = em.createQuery("select x from Country x where x.region=?");
		q.setParameter(1, regionId);
		
		return q.getResultList();
	}

}
