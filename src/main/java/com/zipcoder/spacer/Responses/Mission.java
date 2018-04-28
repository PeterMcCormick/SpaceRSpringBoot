package com.zipcoder.spacer.Responses;


import java.util.List;

public class Mission {
    public int id;
    public String name;
    public String description;
    public int type;
    public String wikiURL;
    public String typeName;
    public List<Agency> agencies;
    public List<Payload> payloads;
}
