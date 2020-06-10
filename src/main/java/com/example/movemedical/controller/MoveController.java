package com.example.movemedical.controller;

import com.example.movemedical.model.UsCity;
import com.example.movemedical.model.UsCounty;
import com.example.movemedical.model.UsState;
import com.example.movemedical.repo.UsCityRepo;
import com.example.movemedical.repo.UsCountyRepo;
import com.example.movemedical.repo.UsStateRepo;
import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api")
public class MoveController {
    final Logger logger = LoggerFactory.getLogger(MoveController.class);

    @Autowired
    private UsStateRepo usStateRepo;

    @Autowired
    private UsCountyRepo usCountyRepo;

    @Autowired
    private UsCityRepo usCityRepo;

    @GetMapping("/findAllStates")
    public ResponseEntity<?> findAllStates() {
        try {
            return ResponseEntity.ok(usStateRepo.findAll());
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not read findAllStates", e));
        }
    }

    @GetMapping("/findAllCounties")
    public ResponseEntity<?> findAllCounties() {
        try {
            return ResponseEntity.ok(usCountyRepo.findAll());
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not read findAllCounties", e));
        }
    }

    @GetMapping("/findAllCities")
    public ResponseEntity<?> findAllCities() {
        try {
            return ResponseEntity.ok(usCityRepo.findAll());
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not read findAllCities", e));
        }
    }

    @PostMapping("/createState")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createState(@RequestBody UsState usState) {
        try {
            Preconditions.checkNotNull(usState);
            return ResponseEntity.ok(usStateRepo.save(usState));
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not save UsState", e));
        }
    }

    @PostMapping("/createCounty")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCounty(@RequestBody UsCounty usCounty) {
        try {
            Preconditions.checkNotNull(usCounty);
            return ResponseEntity.ok(usCountyRepo.save(usCounty));
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not save UsCounty", e));
        }
    }

    @PostMapping("/createCity")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCity(@RequestBody UsCity usCity) {
        try {
            Preconditions.checkNotNull(usCity);
            return ResponseEntity.ok(usCityRepo.save(usCity));
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not save UsCity", e));
        }
    }

    @DeleteMapping(value = "state/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteState(@PathVariable("id") Long stateId) {
        try {
            usStateRepo.deleteById(stateId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not delete UsState", e));
        }
    }

    @DeleteMapping(value = "county/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteCounty(@PathVariable("id") Long countyId) {
        try {
            usCountyRepo.deleteById(countyId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not delete UsCounty", e));
        }
    }

    @DeleteMapping(value = "city/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long cityId) {
        try {
            usCityRepo.deleteById(cityId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
            return buildResponseEntity(requestError("Can not delete UsCity", e));
        }
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<Object>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    private ApiError requestError(String msg, Exception e) {
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, msg, e);
    }
}
