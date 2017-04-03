package org.ril.raspBo.service;

import org.ril.raspBo.model.ClassRoom;
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
public class ServicesClassRoom {
    @Autowired
    RepositoryClassroom repository;

    @Transactional
    public List<ClassRoom> getAll() {
        List<ClassRoom> countries = new ArrayList<ClassRoom>();
        Iterable<ClassRoom> classroomIterable = repository.findAll();
        Iterator<ClassRoom> classroomIterator = classroomIterable.iterator();
        while (classroomIterator.hasNext()) {
            countries.add(classroomIterator.next());
        }
        return countries;
    }

    @Transactional
    public ClassRoom getById(int id) {
        return repository.findOne(id);
    }


    @Transactional
    public void add(ClassRoom object) {
        repository.save(object);
    }

    @Transactional
    public void update(ClassRoom object) {
        repository.save(object);
    }

    @Transactional
    public void delete(int id) {
        repository.delete(id);
    }
}
