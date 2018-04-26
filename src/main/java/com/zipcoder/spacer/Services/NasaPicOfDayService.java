package com.zipcoder.spacer.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcoder.spacer.Domain.NasaPicOfDay;
import com.zipcoder.spacer.Repositories.NasaPicOfDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class NasaPicOfDayService {

    private NasaPicOfDayRepository nasaPicOfDayRepository;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    NasaPicOfDayService(NasaPicOfDayRepository nasaPicOfDayRepository) {
        this.nasaPicOfDayRepository = nasaPicOfDayRepository;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void getNasaPicOfDayFromAPI() {
        HttpEntity entity = new HttpEntity<String>("");
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY",
                HttpMethod.GET, entity , String.class);
        try {
            NasaPicOfDay nasaPicOfDay = new ObjectMapper().readValue(responseEntity.getBody(),
                    NasaPicOfDay.class);
            this.nasaPicOfDayRepository.deleteAll();
            this.nasaPicOfDayRepository.save(nasaPicOfDay);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity getNasaPicOfDayFromDB() {
        return new ResponseEntity(this.nasaPicOfDayRepository.findAll(), HttpStatus.OK);
    }
}
