package com.example.movemedical.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
public class UsState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long stateId;

    private String stateCode;
    private String stateName;

    @OneToMany(
            mappedBy = "usState",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<UsCounty> counties;

    protected UsState() {
    }

    public UsState(String stateCode, String stateName, List<UsCounty> counties) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.counties = counties;
    }

    public UsState(String stateCode, String stateName) {
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return String.format(
                "UsState[stateId=%d, stateCode='%s', stateName='%s', counties='%s']",
                stateId, stateCode, stateName, counties);
    }


    public Long getStateId() {
        return stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public List<UsCounty> getCounties() {
        return counties;
    }

    public UsState setStateId(Long stateId) {
        this.stateId = stateId;
        return this;
    }
}
