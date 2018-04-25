package com.zipcoder.spacer.Services;

import com.zipcoder.spacer.Domain.RocketLaunch;
import com.zipcoder.spacer.Repositories.RocketLaunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Service
public class RocketLaunchService {

    private RocketLaunchRepository rocketLaunchRepository;

    @Autowired
    RocketLaunchService(RocketLaunchRepository rocketLaunchRepository) {
        this.rocketLaunchRepository = rocketLaunchRepository;
    }

    @RequestMapping(value= "/rocketlaunch", method = RequestMethod.POST)
    public void getRocketLaunchFromAPI(@RequestBody RocketLaunch rocketLaunchToUpdate) {
        this.rocketLaunchRepository.save(rocketLaunchToUpdate);

    }

    public ResponseEntity getRocketLaunchFromDB() {
        return new ResponseEntity(this.rocketLaunchRepository.findAll(), HttpStatus.OK);
    }

}
