package com.sapient.moviebookingplatform.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.moviebookingplatform.domain.Theatre;
import com.sapient.moviebookingplatform.dto.BrowseForTheatreDto;
import com.sapient.moviebookingplatform.service.TheatreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TheatreController.class)
public class TheatreControllerTest {


    private TheatreController theatreController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TheatreService theatreService;

    @BeforeEach
    public void setUp(){

        this.theatreController = new TheatreController(theatreService);
    }

    @Test
    public void givenCityMovieNameAndShowTimingShouldReturnListOfTheatresShouldReturnUnSupportedMediaType() throws Exception {

        BrowseForTheatreDto browseForTheatreDto =
                new BrowseForTheatreDto("Gurgaon","Avengers",
                        new Timestamp(System.currentTimeMillis()));

        given(theatreService.getListOfTheatres(any()))
                .willReturn(
                        Arrays.asList(new Theatre("MGF","Gurgaon",120),
                                new Theatre("Ambience","Gurgaon",200),
                                new Theatre("Glory","Gurgaon",100))
                );

        mockMvc.perform(MockMvcRequestBuilders.post("/theatre")
        .content(asJsonString(new BrowseForTheatreDto("Gurgaon","Avengers",
                new Timestamp(System.currentTimeMillis())))).content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().is4xxClientError());


    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
