package com.sapient.moviebookingplatform.repository;

import com.sapient.moviebookingplatform.domain.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {


    public List<Theatre> findByCityAndMovieAndShowTime(String city, String movie, String date) ;

}
