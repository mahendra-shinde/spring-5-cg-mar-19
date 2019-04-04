package com.cg.webapp.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.webapp.models.Country;
import com.cg.webapp.services.ICountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired private ICountryService service;
	
	@RequestMapping("/find")
	// URL http://localhost:5000/countries/find/IN 
	public Country findById(@RequestParam("id") String code) {
		return service.findByCode(code);
	}
	
	@RequestMapping("/find-all")
	public List<Country> findAll(){
		return service.findAll();
	}
}
