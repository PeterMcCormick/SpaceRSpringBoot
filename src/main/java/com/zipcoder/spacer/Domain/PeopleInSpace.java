package com.zipcoder.spacer.Domain;

import javax.persistence.*;

@Entity
public class PeopleInSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="PERSON_ID")
    private int personId;

    @Column (name = "FULL_NAME")
    private String name;

    @Column (name = "SPACE_CRAFT")
    private String craft;

    @Column (name = "WIKI_PAGE")
    private String wikipage;

   public PeopleInSpace(int personId, String name, String craft, String wikipage) {
   }

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
