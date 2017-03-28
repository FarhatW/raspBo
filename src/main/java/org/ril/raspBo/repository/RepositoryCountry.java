package org.ril.raspBo.repository;

import org.ril.raspBo.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryCountry extends  CrudRepository<Country,Integer> {
    
}