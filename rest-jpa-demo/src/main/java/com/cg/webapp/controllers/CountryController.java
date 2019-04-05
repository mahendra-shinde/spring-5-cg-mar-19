package com.cg.webapp.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.webapp.models.Country;
import com.cg.webapp.services.ICountryService;
import com.cg.webapp.utils.NoCountryFoundException;

@RestController
//Allow Angular application running on port 4200 to access these services
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/countries")
public class CountryController {

	@Autowired private ICountryService service;
	
	@RequestMapping("/find/{id}")
	// URL http://localhost:5000/countries/find/IN 
	public Country findById(@PathVariable("id") String code) {
		return service.findByCode(code);
	}
	
	@RequestMapping(value="/find-all",
			produces= {"application/json","application/xml"})
	public List<Country> findAll(){
		return service.findAll();
	}
	
	// POST http://localhost:5000/countries/add
	// Request Body must contain JSON data!
	@RequestMapping(value="/add",
			method=RequestMethod.POST,
			consumes="application/json")
	
//	@PostMapping(value="/add",consumes="application/json")
	public ResponseEntity<String> save(@RequestBody Country country){
		System.out.println("About to save new country");
		service.save(country);
		return new ResponseEntity<>("Country Created!",HttpStatus.OK);
	}
	
	/**
	//Controller LEVEL exception handler
	@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="Country with this ID does not exist!")
	@ExceptionHandler({NoCountryFoundException.class})
	public void handleError() {
		//Nothing required in this method!!!
		System.out.println("Error occurred!");
	}**/
}
