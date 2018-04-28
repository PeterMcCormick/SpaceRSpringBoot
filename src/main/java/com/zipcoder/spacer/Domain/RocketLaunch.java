package com.zipcoder.spacer.Domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "rocket_launch")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RocketLaunch {

    @Id
    @Column(name= "LAUNCH_ID")
    private int launchId;

    @Column(name = "ROCKET")
    private String rocket;

    @Column(name= "PAYLOAD")
    private String payload;

    @Column(name= "DATE")
    private String date;

    @Column(name= "LOCATION")
    private String location;

    @Column(name= "DESCRIPTION")
    private String description;

    @Column(name= "ROCKET_WEBPAGE")
    private String rocketWebpage;

    @Column(name= "PAYLOAD_WEBPAGE")
    private String payloadWebPage;

    @Column(name= "PAD_LATITUDE")
    private String padLatitude;

    @Column(name= "PAD_LONGITUDE")
    private String padLongitude;

    public RocketLaunch(){}

    public RocketLaunch(int launchId, String rocket, String rocketWebpage, String payload, String payloadWebPage,
                        String description, String date, String location, String padLatitude, String padLongitude) {
        this.launchId = launchId;
        this.rocket= rocket;
        this.rocketWebpage = rocketWebpage;
        this.payload = payload;
        this.payloadWebPage = payloadWebPage;
        this.description = description;
        this.date = date;
        this.location = location;
        this.padLatitude = padLatitude;
        this.padLongitude = padLongitude;
        }


    public int getLaunchId() {
        return launchId;
    }

    public void setLaunchId(int launchId) {
        this.launchId = launchId;
    }

    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRocketWebpage() {
        return rocketWebpage;
    }

    public void setRocketWebpage(String rocketWebpage) {
        this.rocketWebpage = rocketWebpage;
    }

    public String getPayloadWebPage() {
        return payloadWebPage;
    }

    public void setPayloadWebPage(String payloadWebPage) {
        this.payloadWebPage = payloadWebPage;
    }

    public String getPadLatitude() {
        return padLatitude;
    }

    public void setPadLatitude(String padLatitude) {
        this.padLatitude = padLatitude;
    }

    public String getPadLongitude() {
        return padLongitude;
    }

    public void setPadLongitude(String padLongitude) {
        this.padLongitude = padLongitude;
    }

    public void setlocation(String padLocation) {
        this.location = padLocation;
    }


    @Override
    public String toString() {
        return "RocketLaunch{" +
                "launchId='" + launchId + '\'' +
                ", rocket='" + rocket + '\'' +
                ", payload='" + payload + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", rocketWebpage='" + rocketWebpage + '\'' +
                ", payloadWebPage='" + payloadWebPage + '\'' +
                ", padLatitude='" + padLatitude + '\'' +
                ", padLongitude='" + padLongitude + '\'' +
                '}';
    }
}
