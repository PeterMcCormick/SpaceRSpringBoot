package com.zipcoder.spacer.Controllers;

import com.zipcoder.spacer.Services.IssLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssLocationController {

    private IssLocationService issLocationService;

    @Autowired
    IssLocationController(IssLocationService issLocationService) {
        this.issLocationService = issLocationService;
    }

    @CrossOrigin
    @RequestMapping(value= "/iss_location", method = RequestMethod.GET)
    public ResponseEntity getIssLocationFromDataBase() {
        return this.issLocationService.getIssLocationFromDB();
    }

}
