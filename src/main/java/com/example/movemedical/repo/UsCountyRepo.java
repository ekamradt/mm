package com.example.movemedical.repo;

import com.example.movemedical.model.UsCounty;
import com.example.movemedical.model.UsState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsCountyRepo extends CrudRepository<UsCounty, Long> {
    List<UsCounty> findByCountyName(String countyName);

    List<UsCounty> findAll();

    List<UsCounty> findByUsState(UsState usState);
}
