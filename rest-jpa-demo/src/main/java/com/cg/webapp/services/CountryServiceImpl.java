package com.cg.webapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.webapp.dao.ICountryDAO;
import com.cg.webapp.models.Country;
import com.cg.webapp.utils.NoCountryFoundException;

@Service
public class CountryServiceImpl implements ICountryService {

	@Autowired private ICountryDAO dao;
	
	@Override
	public Country findByCode(String code) {
		
		System.out.println("Invoking dao.findById "+code);
		Optional<Country> country = dao.findById(code);
		if(! country.isPresent()) {
			throw new NoCountryFoundException(code);
		}
		return country.get();
	}

	@Override
	public void save(Country country) {
		System.out.println("Invoking dao.save");
		dao.save(country);
	}

	@Override
	public List<Country> findAll() {
		System.out.println("Invoking dao.findAll");
		return dao.findAll();
	}

}
