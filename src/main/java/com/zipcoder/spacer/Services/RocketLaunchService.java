package com.zipcoder.spacer.Services;

import com.fasterxml.jackson.databind.*;
import com.zipcoder.spacer.Domain.RocketLaunch;
import com.zipcoder.spacer.Repositories.RocketLaunchRepository;
import com.zipcoder.spacer.Responses.Launch;
import com.zipcoder.spacer.Responses.LaunchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;


@Service
public class RocketLaunchService {

    private RocketLaunchRepository rocketLaunchRepository;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    RocketLaunchService(RocketLaunchRepository rocketLaunchRepository) {
        this.rocketLaunchRepository = rocketLaunchRepository;
    }

    @Scheduled(fixedDelay = 43200000)
    public void getRocketLaunchFromAPI() {
        HttpEntity entity = new HttpEntity<String>("");
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://launchlibrary.net/1.4/launch/next/10",
                HttpMethod.GET, entity , String.class);
        try {
            LaunchResponse rocketLaunch = new ObjectMapper().readValue(responseEntity.getBody(),
                    LaunchResponse.class);

            ArrayList<RocketLaunch> rocketLaunches = new ArrayList<>();
            for (Launch launch: rocketLaunch.launches) {
                int rocketId = launch.id;
                String rocket = launch.rocket.name;
                String payload = launch.missions.get(0).name;
                String date = launch.windowstart;
                String location = launch.location.name;
                String description = launch.missions.get(0).description;
                String rocketWebpage = launch.rocket.wikiURL;
                String payloadWebpage = launch.missions.get(0).wikiURL;
                String padLatitude = Double.toString(launch.location.pads.get(0).latitude);
                String padLongitude = Double.toString(launch.location.pads.get(0).longitude);
                RocketLaunch rocketLaunchToAdd = new RocketLaunch(rocketId,rocket,rocketWebpage,payload,payloadWebpage,
                        description,date,location,padLatitude,padLongitude);
                rocketLaunches.add(rocketLaunchToAdd);
            }

            this.rocketLaunchRepository.deleteAll();
            this.rocketLaunchRepository.saveAll(rocketLaunches);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ResponseEntity getRocketLaunchFromDB() {
        return new ResponseEntity(this.rocketLaunchRepository.findAll(), HttpStatus.OK);
    }

}
