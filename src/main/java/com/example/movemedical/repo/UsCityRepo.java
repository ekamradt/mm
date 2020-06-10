package com.example.movemedical.repo;

import com.example.movemedical.model.UsCity;
import com.example.movemedical.model.UsCounty;
import com.example.movemedical.model.UsState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsCityRepo extends CrudRepository<UsCity, Long> {
    List<UsCity> findByCityName(String countyName);

    List<UsCity> findAll();

    List<UsCity> findByUsCounty(UsCounty usCounty);
}
