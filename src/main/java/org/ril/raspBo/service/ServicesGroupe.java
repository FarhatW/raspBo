package org.ril.raspBo.service;

import org.ril.raspBo.model.Groupe;
import org.ril.raspBo.model.Groupe;
import org.ril.raspBo.repository.RepositoryClassroom;
import org.ril.raspBo.repository.RepositoryGroupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Service("ServicesGroupe")
public class ServicesGroupe {
    @Autowired
    RepositoryGroupe repository;

    @Transactional
    public List<Groupe> getAll() {
        List<Groupe> groupes = new ArrayList<Groupe>();
        Iterable<Groupe> groupeIterable = repository.findAll();
        Iterator<Groupe> groupeIterator = groupeIterable.iterator();
        while (groupeIterator.hasNext()) {
            groupes.add(groupeIterator.next());
        }
        return groupes;
    }

    @Transactional
    public Groupe getById(int id) {
        return repository.findOne(id);
    }


    @Transactional
    public void add(Groupe object) {
        repository.save(object);
    }

    @Transactional
    public void update(Groupe object) {
        repository.save(object);

    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
