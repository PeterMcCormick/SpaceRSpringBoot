package com.zipcoder.spacer.Domain;

import javax.persistence.*;

@Entity
@Table(name = "people_in_space")
public class PeopleInSpace {

    @Id
    @Column(name ="PERSON_ID")
    private int personId;

    @Column (name = "FULL_NAME")
    private String name;

    @Column (name = "SPACE_CRAFT")
    private String craft;

    @Column (name = "WIKIPAGE")
    private String wikipage;


   public int getPersonId() {
      return personId;
   }

   public void setPersonId(int personId) {
      this.personId = personId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCraft() {
      return craft;
   }

   public void setCraft(String craft) {
      this.craft = craft;
   }

    public String getWikipage() {
        return wikipage;
    }

    public void setWikipage(String wikipage) {
        this.wikipage = wikipage;
    }

    @Override
    public String toString() {
        return "PeopleInSpace{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", craft='" + craft + '\'' +
                ", wikipage='" + wikipage + '\'' +
                '}';
    }
}
