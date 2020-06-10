package com.example.movemedical.controller;

import com.example.movemedical.model.UsCity;
import com.example.movemedical.model.UsCounty;
import com.example.movemedical.model.UsState;
import com.example.movemedical.repo.UsCityRepo;
import com.example.movemedical.repo.UsCountyRepo;
import com.example.movemedical.repo.UsStateRepo;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class MoveController {

    @Autowired
    private UsStateRepo usStateRepo;
    @Autowired
    private UsCountyRepo usCountyRepo;
    @Autowired
    private UsCityRepo usCityRepo;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/findAllStates")
    public List<UsState> findAllStates() {
        return usStateRepo.findAll();
    }

    @GetMapping("/findAllCounties")
    public List<UsCounty> findAllCounties() {
        return usCountyRepo.findAll();
    }

    @GetMapping("/findAllCities")
    public List<UsCity> findAllCities() {
        return usCityRepo.findAll();
    }

    @PostMapping("/createState")
    @ResponseStatus(HttpStatus.CREATED)
    public UsState createState(@RequestBody UsState usState) {
        Preconditions.checkNotNull(usState);
        return usStateRepo.save(usState);
    }

    @PostMapping("/createCounty")
    @ResponseStatus(HttpStatus.CREATED)
    public UsCounty createCounty(@RequestBody UsCounty usCounty) {
        Preconditions.checkNotNull(usCounty);
        return usCountyRepo.save(usCounty);
    }

    @PostMapping("/createCity")
    @ResponseStatus(HttpStatus.CREATED)
    public UsCity createCity(@RequestBody UsCity usCity) {
        Preconditions.checkNotNull(usCity);
        return usCityRepo.save(usCity);
    }

    @DeleteMapping(value = "state/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteState(@PathVariable("id") Long stateId) {
        usStateRepo.deleteById(stateId);
    }

    @DeleteMapping(value = "county/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCounty(@PathVariable("id") Long countyId) {
        usCountyRepo.deleteById(countyId);
    }

    @DeleteMapping(value = "city/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCity(@PathVariable("id") Long cityId) {
        usCityRepo.deleteById(cityId);
    }
}
