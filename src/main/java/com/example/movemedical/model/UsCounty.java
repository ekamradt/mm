package com.example.movemedical.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
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
    private Set<UsCity> cities;

    protected UsCounty() {
    }

    public UsCounty(UsState usState, String countyName, Set<UsCity> cities) {
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

    public Set<UsCity> getCities() {
        return cities;
    }

    @JsonSetter
    public void setUsState(UsState usState) {
        this.usState = usState;
    }
}
