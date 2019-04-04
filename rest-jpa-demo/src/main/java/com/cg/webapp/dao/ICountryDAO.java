package com.cg.webapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.webapp.models.Country;

@Repository
public interface ICountryDAO extends JpaRepository<Country, String>{
	
}
