package com.sapient.moviebookingplatform.domain;

public class Theatre {

    private String name;
    private String location;
    private Integer capacity;

    public Theatre() {
    }

    public Theatre(String name, String location, Integer capacity) {

        this.name = name ;
        this.location = location ;
        this.capacity = capacity;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
