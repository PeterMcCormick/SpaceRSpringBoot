package com.zipcoder.spacer.Domain;


import javax.persistence.*;

@Entity
public class RocketLaunch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "LAUNCH_ID")
    private String launchId;

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


    public RocketLaunch(String launchId, String rocket, String payload, String date, String location,
                        String description, String rocketWebpage, String payloadWebPage, String padLatitude,
                        String padLongitude) {

    }

    public String getLaunchId() {
        return launchId;
    }

    public void setLaunchId(String launchId) {
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

    public void setLocation(String location) {
        this.location = location;
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
