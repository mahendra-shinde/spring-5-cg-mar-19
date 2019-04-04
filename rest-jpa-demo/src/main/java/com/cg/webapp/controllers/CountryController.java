package com.cg.webapp.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	// POST http://localhost:5000/countries/add
	// Request Body must contain JSON data!
	@RequestMapping(value="/add",
			method=RequestMethod.POST,
			consumes="application/json")
	public ResponseEntity<String> save(@RequestBody Country country){
		System.out.println("About to save new country");
		service.save(country);
		return new ResponseEntity<>("Country Created!",HttpStatus.OK);
	}
}
