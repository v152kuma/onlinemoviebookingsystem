package com.sapient.moviebookingplatform.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BrowseForTheatreDto {


    private String city;

    private String movie;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp showtiming;

    public  BrowseForTheatreDto()
    {

    }
    public BrowseForTheatreDto(String city, String movie, Timestamp showtiming) {
        this.city = city;
        this.movie = movie;
        this.showtiming = showtiming;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Timestamp getShowtiming() {
        return showtiming;
    }

    public void setShowtiming(Timestamp showtiming) {
        this.showtiming = showtiming;
    }
}
