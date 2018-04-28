package com.zipcoder.spacer.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;

@Entity
@Table(name = "iss_location")
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssLocation {


    @Id
    @Column(name = "TIMESTAMP")
    private int timestamp;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;

    public int getTimestamp() {
        return timestamp;
    }

    private IssLocation(){}

    public IssLocation(String result)throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        this.timestamp = objectMapper.readTree(result).get("timestamp").asInt();
        this.latitude = objectMapper.readTree(result).get("iss_position").get("latitude").asText();
        this.longitude = objectMapper.readTree(result).get("iss_position").get("longitude").asText();
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "IssLocation{" +
                "locationId=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
