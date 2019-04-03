package com.mahendra.entities;

import javax.persistence.*;

@Entity
@Table(name="countries")
public class Country {

	@Id
	@Column(name="country_id")
	private String code;
	
	@Column(name="country_name",length=40)
	private String name;
	
	@Column(name="region_id")
	private Integer region;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}
	
}
