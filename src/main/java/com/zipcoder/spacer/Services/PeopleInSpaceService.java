package com.zipcoder.spacer.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcoder.spacer.Domain.PeopleInSpaceList;
import com.zipcoder.spacer.Repositories.PeopleInSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class PeopleInSpaceService {

    private PeopleInSpaceRepository peopleInSpaceRepository;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    PeopleInSpaceService(PeopleInSpaceRepository peopleInSpaceRepository){
        this.peopleInSpaceRepository = peopleInSpaceRepository;
    }


    @Scheduled(fixedDelay = 43200000)
    public void getPeopleFromAPI(){
        HttpEntity entity = new HttpEntity<String>("");
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://api.open-notify.org/astros.json",
                HttpMethod.GET, entity , String.class);
        try {
            PeopleInSpaceList peopleInSpaceList = new ObjectMapper().readValue(responseEntity.getBody(),
                    PeopleInSpaceList.class);
            this.peopleInSpaceRepository.deleteAll();
            this.peopleInSpaceRepository.saveAll(peopleInSpaceList.getPeople());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity getPeopleFromDB(){
        return new ResponseEntity(this.peopleInSpaceRepository.findAll(),HttpStatus.OK);
    }


}
