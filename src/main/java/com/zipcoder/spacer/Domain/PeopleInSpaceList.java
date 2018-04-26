package com.zipcoder.spacer.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleInSpaceList {

    public List<PeopleInSpace> people;

    public List<PeopleInSpace> getPeople() {
        return people;
    }

    public void setPeople(List<PeopleInSpace> people) {
        this.people = people;
    }
}
