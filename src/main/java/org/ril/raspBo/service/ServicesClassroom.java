package org.ril.raspBo.service;

import org.ril.raspBo.model.Classroom;
import org.ril.raspBo.repository.RepositoryClassroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gamer on 28/03/2017.
 */
@Service("ServicesClassroom")
public class ServicesClassroom {
    @Autowired
    RepositoryClassroom repository;

    @Transactional
    public List<Classroom> getAll() {
        List<Classroom> countries = new ArrayList<Classroom>();
        Iterable<Classroom> classroomIterable = repository.findAll();
        Iterator<Classroom> classroomIterator = classroomIterable.iterator();
        while (classroomIterator.hasNext()) {
            countries.add(classroomIterator.next());
        }
        return countries;
    }

    @Transactional
    public Classroom getById(int id) {
        return repository.findOne(id);
    }


    @Transactional
    public void add(Classroom object) {
        repository.save(object);
    }

    @Transactional
    public void update(Classroom object) {
        repository.save(object);

    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
