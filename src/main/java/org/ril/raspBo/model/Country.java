package org.ril.raspBo.model;

import javax.persistence.*;

/*
 * This is our model class and it corresponds to Country table in database
 */
@Entity
@Table(name= "country")
public class Country{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;

	@Column(name= "name")
	String countryName;	


	public Country() {
		super();
	}

	public Country(int i, String countryName,long population) {
		super();
		this.id = i;
		this.countryName = countryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}