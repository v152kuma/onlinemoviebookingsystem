package com.sapient.moviebookingplatform.functionaltests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.moviebookingplatform.MoviebookingplatformApplication;
import com.sapient.moviebookingplatform.dto.BrowseForTheatreDto;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MoviebookingplatformApplication.class)
public class EndpointTests {


    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Nested
    @DisplayName("Given the endpoint for theatre browsing services")
    class TheatreReadingServices {

        @BeforeEach
        void setup() {

        }


        @DisplayName("When city ,movie and show timing is passed")
        @Test
        void shouldReturnTheatreListGivenTheCityAndMovieAndShowTiming(){

            BrowseForTheatreDto browseForTheatreDto = new BrowseForTheatreDto("Gurgaon","Avengers",
                    new Timestamp(System.currentTimeMillis()));

            HttpEntity<BrowseForTheatreDto> request = new HttpEntity<>(browseForTheatreDto);

            assertAll("Then should return a list of theatres",
                    ()-> {
                        ResponseEntity tResponseEntity = restTemplate.postForEntity("/theatre", request, String.class);
                        assertEquals(HttpStatus.OK, tResponseEntity.getStatusCode());
                    });
        }

    }

}
