package org.ril.raspBo.service;

import org.ril.raspBo.model.City;
import org.ril.raspBo.repository.RepositoryCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Service("ServicesCity")
public class ServicesCity {

    @Autowired
    RepositoryCity repository;

    @Transactional
    public List<City> getAll() {
        List<City> countries = new ArrayList<City>();
        Iterable<City> cityIterable = repository.findAll();
        Iterator<City> cityIterator = cityIterable.iterator();
        while (cityIterator.hasNext()) {
            countries.add(cityIterator.next());
        }
        return countries;
    }

    @Transactional
    public City getById(int id) {
        return repository.findOne(id);
    }


    @Transactional
    public void add(City object) {
        repository.save(object);
    }

    @Transactional
    public void update(City object) {
        repository.save(object);

    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
