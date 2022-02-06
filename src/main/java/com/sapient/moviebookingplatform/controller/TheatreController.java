package com.sapient.moviebookingplatform.controller;


import com.sapient.moviebookingplatform.dto.BrowseForTheatreDto;
import com.sapient.moviebookingplatform.service.TheatreService;
import org.hibernate.loader.plan.exec.process.spi.ResultSetProcessingContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService ;
    }

    @PostMapping
    public ResponseEntity theatreListBasedOnCityMovieAndTiming(@RequestBody
                                                                       BrowseForTheatreDto browseForTheatreDto) {
        return ResponseEntity.ok().build();
    }

}
