package com.sapient.moviebookingplatform.service;

import com.sapient.moviebookingplatform.domain.Theatre;
import com.sapient.moviebookingplatform.dto.BrowseForTheatreDto;
import com.sapient.moviebookingplatform.repository.TheatreRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.rmi.server.ExportException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
public class TheatreServiceTest {

    @Mock
    private TheatreRepository theatreRepository;

    private TheatreService theatreService;

    @BeforeEach
    public void setUp() throws Exception{
        theatreService = new TheatreService(theatreRepository);
    }

    @Test()
    public void getTheatreDetails(){


        given(theatreRepository.findByCityAndMovieAndShowTime(any(),any(),any()))
                .willReturn(any());

        theatreService.getListOfTheatres( new BrowseForTheatreDto("Gurgaon","Avengers",
                new Timestamp(System.currentTimeMillis())));

        assert (true);


    }
}
