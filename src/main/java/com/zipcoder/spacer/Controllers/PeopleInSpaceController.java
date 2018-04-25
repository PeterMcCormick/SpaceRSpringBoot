package com.zipcoder.spacer.Controllers;

import com.zipcoder.spacer.Services.PeopleInSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleInSpaceController {

    private PeopleInSpaceService peopleInSpaceService;

    @Autowired
    PeopleInSpaceController(PeopleInSpaceService peopleInSpaceService){
        this.peopleInSpaceService = peopleInSpaceService;
    }

    @RequestMapping(value = "/people_in_space", method = RequestMethod.GET)
    public ResponseEntity getPeopleFromDataBase(){
        return this.peopleInSpaceService.getPeopleFromDB();
    }

}
