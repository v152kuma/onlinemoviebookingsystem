package com.sapient.moviebookingplatform.service;

import com.sapient.moviebookingplatform.dto.BrowseForTheatreDto;
import com.sapient.moviebookingplatform.repository.TheatreRepository;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {


    private TheatreRepository theatreRepository;


    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public Object getListOfTheatres(BrowseForTheatreDto browseForTheatreDto) {
        return null;
    }
}
