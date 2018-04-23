package com.zipcoder.spacer.Domain;



@Entity
public class RocketLaunch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "")
    private String launchId;

    private String rocket;

    private String payload;

    private String date;

    private String location;

    private String description;

    private String rocketWebpage;

    private String payloadWebPage;

    private String padLatitude;

    private String padLongitude;

}
