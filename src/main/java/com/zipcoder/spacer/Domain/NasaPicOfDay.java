package com.zipcoder.spacer.Domain;

import javax.persistence.*;

@Entity
@Table(name = "nasa_pic_of_the_day)")
public class NasaPicOfDay {

    @Id
    @Column(name = "PIC_ID")
    private int picId;

    @Column(name = "COPYRIGHT")
    private String copyright;

    @Column(name= "EXPLANATION")
    private String explanation;

    @Column(name= "TITLE")
    private String title;

    @Column(name= "LOCATION")
    private String location;


    public NasaPicOfDay(int picId, String copyright, String explanation, String title, String location) {

    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "NasaPicOfDay{" +
                "picId=" + picId +
                ", copyright='" + copyright + '\'' +
                ", explanation='" + explanation + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
