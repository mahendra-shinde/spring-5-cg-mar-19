package com.mahendra.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mahendra.entities.Country;

// PRE_REQUISITE: Must include "spring-test" in pom.xml
@RunWith(SpringJUnit4ClassRunner.class) //Inform JUnit about Spring TEST
@ContextConfiguration("classpath:/spring/application-config.xml")
public class CountryDAOImplTest {
	
	@Autowired
	private CountryDAO dao;

	@Test
	public void testFindById() {
		Country c = dao.findById("IN");
		assertEquals("India", c.getName());
	}

	@Test
	public void testFindByRegion() {
		List<Country> countries = dao.findByRegion(3);
		assertEquals(6, countries.size());
	}
}
