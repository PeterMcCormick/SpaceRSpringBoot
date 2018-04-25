package com.zipcoder.spacer.Controllers;

import com.zipcoder.spacer.Services.NasaPicOfDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NasaPicOfDayController {

    private NasaPicOfDayService nasaPicOfDayService;

    @Autowired
    NasaPicOfDayController(NasaPicOfDayService nasaPicOfDayService) {
        this.nasaPicOfDayService = nasaPicOfDayService;
    }

    @RequestMapping(value= "/nasa_pic_of_day", method = RequestMethod.GET)
    public ResponseEntity getNasaPicOfDayFromDataBase() {
        return this.nasaPicOfDayService.getNasaPicOfDayFromDB();
    }

}
