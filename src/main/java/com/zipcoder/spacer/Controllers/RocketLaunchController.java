package com.zipcoder.spacer.Controllers;

import com.zipcoder.spacer.Services.RocketLaunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RocketLaunchController {

    private RocketLaunchService rocketLaunchService;

    @Autowired
    RocketLaunchController(RocketLaunchService rocketLaunchService) {
        this.rocketLaunchService = rocketLaunchService;
    }

    @RequestMapping(value= "/rocket_launch", method = RequestMethod.GET)
    public ResponseEntity getRocketLaunchFromDataBase() {
        return this.rocketLaunchService.getRocketLaunchFromDB();
    }

}
