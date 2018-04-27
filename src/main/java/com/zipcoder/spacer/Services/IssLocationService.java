package com.zipcoder.spacer.Services;


import com.zipcoder.spacer.Domain.IssLocation;
import com.zipcoder.spacer.Repositories.IssLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;


@Service
public class IssLocationService {

    private IssLocationRepository issLocationRepository;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    IssLocationService(IssLocationRepository issLocationRepository) {
        this.issLocationRepository = issLocationRepository;
    }

    @Scheduled(fixedDelay = 60000)
    public void getIssLocationFromAPI() {
        HttpEntity entity = new HttpEntity<String>("");
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://api.open-notify.org/iss-now.json",
                HttpMethod.GET, entity , String.class);
        try {
            IssLocation issLocation = new IssLocation(responseEntity.getBody());
            this.issLocationRepository.deleteAll();
            this.issLocationRepository.save(issLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity getIssLocationFromDB() {
        return new ResponseEntity(this.issLocationRepository.findAll(), HttpStatus.OK);
    }

}
