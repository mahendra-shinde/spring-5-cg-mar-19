package com.mahendra.dao;

import java.util.List;

import com.mahendra.entities.Country;

public interface CountryDAO {

	 Country findById(String code);
	 List<Country> findByRegion(Integer regionId);
}
