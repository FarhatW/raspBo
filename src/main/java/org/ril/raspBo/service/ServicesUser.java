package org.ril.raspBo.service;

import org.ril.raspBo.model.User;
import org.ril.raspBo.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("ServicesUser")
public class ServicesUser {

    @Autowired
    RepositoryUser repositoryUser;

    @Transactional
    public List<User> getAll() {
        List<User> countries = new ArrayList<User>();
        Iterable<User> countriesIterable = repositoryUser.findAll();
        Iterator<User> countriesIterator = countriesIterable.iterator();
        while (countriesIterator.hasNext()) {
            countries.add(countriesIterator.next());
        }
        return countries;
    }

    @Transactional
    public User getById(int id) {
        return repositoryUser.findOne(id);
    }

    @Transactional
    public User getByEmail(String email) {
        return repositoryUser.getUserByEmail(email);
    }

    @Transactional
    public void add(User object) {
        repositoryUser.save(object);
    }

    @Transactional
    public void update(User object) {
        repositoryUser.save(object);

    }

    @Transactional
    public void delete(int id) {
        repositoryUser.delete(id);
    }
}
