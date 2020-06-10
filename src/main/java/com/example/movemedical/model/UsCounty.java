package com.example.movemedical.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
public class UsCounty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "county_id")
    private Long countyId;

    private String countyName;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private UsState usState;

    @OneToMany(
            mappedBy = "usCounty",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<UsCity> cities;

    protected UsCounty() {
    }

    public UsCounty(UsState usState, String countyName, List<UsCity> cities) {
        this.usState = usState;
        this.countyName = countyName;
        this.cities = cities;
    }

    @Override
    public String toString() {
        return String.format(
                "UsCounty[countyId=%d,  countyName='%s, cities='%s'']",
                countyId, countyName, cities);
    }

    public Long getCountyId() {
        return countyId;
    }

    public String getCountyName() {
        return countyName;
    }

    @JsonIgnore
    public UsState getUsState() {
        return usState;
    }

    public List<UsCity> getCities() {
        return cities;
    }

    @JsonSetter
    public void setUsState(UsState usState) {
        this.usState = usState;
    }
}
