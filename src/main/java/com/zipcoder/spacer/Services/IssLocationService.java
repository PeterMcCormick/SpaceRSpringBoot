package com.zipcoder.spacer.Services;

import com.zipcoder.spacer.Domain.IssLocation;
import com.zipcoder.spacer.Repositories.IssLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Service
public class IssLocationService {

    private IssLocationRepository issLocationRepository;

    @Autowired
    IssLocationService(IssLocationRepository issLocationRepository) {
        this.issLocationRepository = issLocationRepository;
    }

    @RequestMapping(value= "/isslocation", method = RequestMethod.POST)
    public void getIssLocationFromAPI(@RequestBody IssLocation issLocationToUpdate) {
        this.issLocationRepository.save(issLocationToUpdate);
    }

    public ResponseEntity getIssLocationFromDB() {
        return new ResponseEntity(this.issLocationRepository.findAll(), HttpStatus.OK);
    }

}
