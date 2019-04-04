package com.cg.webapp.services;

import java.util.List;

import com.cg.webapp.models.Country;

public interface ICountryService {
	public Country findByCode(String code);
	public void save(Country country);
	public List<Country> findAll();
	
}
