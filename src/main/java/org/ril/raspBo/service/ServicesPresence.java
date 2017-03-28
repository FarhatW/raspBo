package org.ril.raspBo.service;

import org.ril.raspBo.model.Presence;
import org.ril.raspBo.model.Presence;
import org.ril.raspBo.repository.RepositoryClassroom;
import org.ril.raspBo.repository.RepositoryPresence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Service("ServicesPresence")
public class ServicesPresence {
    @Autowired
    RepositoryPresence repository;

    @Transactional
    public List<Presence> getAll() {
        List<Presence> countries = new ArrayList<Presence>();
        Iterable<Presence> presenceIterable = repository.findAll();
        Iterator<Presence> presenceIterator = presenceIterable.iterator();
        while (presenceIterator.hasNext()) {
            countries.add(presenceIterator.next());
        }
        return countries;
    }

    @Transactional
    public Presence getById(int id) {
        return repository.findOne(id);
    }


    @Transactional
    public void add(Presence object) {
        repository.save(object);
    }

    @Transactional
    public void update(Presence object) {
        repository.save(object);

    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
