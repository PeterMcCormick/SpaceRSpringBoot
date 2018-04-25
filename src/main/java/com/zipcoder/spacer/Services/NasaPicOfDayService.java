package com.zipcoder.spacer.Services;

import com.zipcoder.spacer.Domain.NasaPicOfDay;
import com.zipcoder.spacer.Repositories.NasaPicOfDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class NasaPicOfDayService {

    private NasaPicOfDayRepository nasaPicOfDayRepository;

    @Autowired
    NasaPicOfDayService(NasaPicOfDayRepository nasaPicOfDayRepository) {
        this.nasaPicOfDayRepository = nasaPicOfDayRepository;

    }

    @RequestMapping(value = "/nasapicofday", method = RequestMethod.POST)
    public void getNasaPicOfDayFromAPI(@RequestBody NasaPicOfDay nasaPicOfDayToUpdate) {
        this.nasaPicOfDayRepository.save(nasaPicOfDayToUpdate);
    }

    public ResponseEntity getNasaPicOfDayFromDB() {
        return new ResponseEntity(this.nasaPicOfDayRepository.findAll(), HttpStatus.OK);
    }
}
