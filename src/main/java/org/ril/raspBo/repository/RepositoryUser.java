package org.ril.raspBo.repository;

import org.ril.raspBo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositoryUser extends  CrudRepository<User,Integer> {

    public User getUserByEmail(String email);
}