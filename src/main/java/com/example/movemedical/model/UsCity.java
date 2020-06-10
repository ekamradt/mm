package com.example.movemedical.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
public class UsCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    private String cityName;

    @ManyToOne
    @JoinColumn(name = "county_id")
    private UsCounty usCounty;

    protected UsCity() {
    }

    public UsCity(UsCounty usCounty, String cityName) {
        this.usCounty = usCounty;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return String.format("UsCity[cityId=%d,  cityName='%s']", cityId, cityName);
    }

    public Long getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    @JsonIgnore
    public UsCounty getUsCounty() {
        return usCounty;
    }

    @JsonSetter
    public void setUsCounty(UsCounty usCounty) {
        this.usCounty = usCounty;
    }
}
