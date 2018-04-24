package com.zipcoder.spacer.Services;

import com.zipcoder.spacer.Domain.IssLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class IssLocationService {



    @Autowired
    public IssLocationService() {

    }

    public ResponseEntity<IssLocation> getIssLocation() {
        IssLocation issLocation = issLocationRepository;
        return new ResponseEntity<>(issLocation, HttpStatus.OK);
    }
}
