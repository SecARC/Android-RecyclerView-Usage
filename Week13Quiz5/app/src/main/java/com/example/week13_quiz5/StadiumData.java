package com.example.week13_quiz5;

public class StadiumData {
    private final String name;
    private final String location;
    private final String capacity;
    private final String picture_url;

    public StadiumData(String name, String location,String capacity, String picture_url) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.picture_url = picture_url;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCapacity(){
        return capacity;
    }

    public String getPicture_url() {
        return picture_url;
    }
}
