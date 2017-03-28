package org.ril.raspBo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ril.raspBo.model.Country;
import org.ril.raspBo.repository.RepositoryCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicesCountry")
public class ServicesCountry {

	@Autowired
	RepositoryCountry repositoryCountry;
	
	@Transactional
	public List<Country> getAll() {
		List<Country> countries=new ArrayList<Country>();
		Iterable<Country> countriesIterable= repositoryCountry.findAll();
		Iterator<Country> countriesIterator=countriesIterable.iterator();
		while(countriesIterator.hasNext())
		{
			countries.add(countriesIterator.next());
		}
		return countries;
	}

	@Transactional
	public Country getById(int id) {
		return repositoryCountry.findOne(id);
	}

	@Transactional
	public void add(Country object) {
		repositoryCountry.save(object);
	}

	@Transactional
	public void update(Country object) {
		repositoryCountry.save(object);

	}

	@Transactional
	public void delete(int id) {
		repositoryCountry.delete(id);
	}
}
