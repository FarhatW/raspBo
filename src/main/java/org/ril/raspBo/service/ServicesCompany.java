package org.ril.raspBo.service;

import org.ril.raspBo.model.Company;
import org.ril.raspBo.model.Company;
import org.ril.raspBo.repository.RepositoryClassroom;
import org.ril.raspBo.repository.RepositoryCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Service("ServicesCompany")
public class ServicesCompany {
    @Autowired
    RepositoryCompany repository;

    @Transactional
    public List<Company> getAll() {
        List<Company> countries = new ArrayList<Company>();
        Iterable<Company> companyIterable = repository.findAll();
        Iterator<Company> companyIterator = companyIterable.iterator();
        while (companyIterator.hasNext()) {
            countries.add(companyIterator.next());
        }
        return countries;
    }

    @Transactional
    public Company getById(int id) {
        return repository.findOne(id);
    }


    @Transactional
    public void add(Company object) {
        repository.save(object);
    }

    @Transactional
    public void update(Company object) {
        repository.save(object);

    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
