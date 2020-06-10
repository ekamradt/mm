package com.example.movemedical.repo;

import com.example.movemedical.model.UsState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsStateRepo extends CrudRepository<UsState, Long> {
    List<UsState> findByStateName(String stateName);

    List<UsState> findAll();

    UsState findByStateId(long stateId);
}