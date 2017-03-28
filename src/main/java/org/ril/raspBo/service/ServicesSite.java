package org.ril.raspBo.service;

import org.ril.raspBo.model.Site;
import org.ril.raspBo.model.Site;
import org.ril.raspBo.repository.RepositoryClassroom;
import org.ril.raspBo.repository.RepositorySite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Service("ServicesSite")
public class ServicesSite {
    @Autowired
    RepositorySite repository;

    @Transactional
    public List<Site> getAll() {
        List<Site> countries = new ArrayList<Site>();
        Iterable<Site> siteIterable = repository.findAll();
        Iterator<Site> siteIterator = siteIterable.iterator();
        while (siteIterator.hasNext()) {
            countries.add(siteIterator.next());
        }
        return countries;
    }

    @Transactional
    public Site getById(int id) {
        return repository.findOne(id);
    }


    @Transactional
    public void add(Site object) {
        repository.save(object);
    }

    @Transactional
    public void update(Site object) {
        repository.save(object);

    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
