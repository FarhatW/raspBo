package org.ril.raspBo.service;

import org.ril.raspBo.model.UserHasGroupe;
import org.ril.raspBo.repository.RespositoryUserHasGroupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gamer on 04/04/2017.
 */
@Service("ServicesUserhasGroupe")
public class ServicesUserhasGroupe {
    @Autowired
    RespositoryUserHasGroupe respositoryUserHasGroupe;

    @Transactional
    public List<UserHasGroupe> getAll() {
        List<UserHasGroupe> userHasGroupes = new ArrayList<UserHasGroupe>();
        Iterable<UserHasGroupe> userHasGroupeIterable = respositoryUserHasGroupe.findAll();
        Iterator<UserHasGroupe> userHasGroupeIterator = userHasGroupeIterable.iterator();
        while (userHasGroupeIterator.hasNext()) {
            userHasGroupes.add(userHasGroupeIterator.next());
        }
        return userHasGroupes;
    }

    @Transactional
    public UserHasGroupe getById(int id) {
        return respositoryUserHasGroupe.findOne(id);
    }


    @Transactional
    public void add(UserHasGroupe object) {
        respositoryUserHasGroupe.save(object);
    }

    @Transactional
    public void update(UserHasGroupe object) {
        respositoryUserHasGroupe.save(object);

    }

    @Transactional
    public void delete(int id) {
        respositoryUserHasGroupe.delete(id);
    }
}
