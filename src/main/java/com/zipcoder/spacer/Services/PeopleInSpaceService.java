package com.zipcoder.spacer.Services;

import com.zipcoder.spacer.Domain.PeopleInSpace;
import com.zipcoder.spacer.Repositories.PeopleInSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PeopleInSpaceService {

    private PeopleInSpaceRepository peopleInSpaceRepository;

    @Autowired
    PeopleInSpaceService(PeopleInSpaceRepository peopleInSpaceRepository){
        this.peopleInSpaceRepository = peopleInSpaceRepository;
    }


    //@EventListener(ApplicationReadyEvent.class)
    @RequestMapping(value = "/peopleinspace", method = RequestMethod.POST)
    public void getPeopleFromAPI(@RequestBody PeopleInSpace peopleToUpdate){
        this.peopleInSpaceRepository.save(peopleToUpdate);
    }

    public ResponseEntity getPeopleFromDB(){
        return new ResponseEntity(this.peopleInSpaceRepository.findAll(),HttpStatus.OK);
    }


}
