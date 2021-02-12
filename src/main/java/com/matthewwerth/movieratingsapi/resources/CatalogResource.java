package com.matthewwerth.movieratingsapi.resources;

import com.matthewwerth.movieratingsapi.models.CatalogItem;
import com.matthewwerth.movieratingsapi.models.Movie;
import com.matthewwerth.movieratingsapi.models.Rating;
import com.matthewwerth.movieratingsapi.models.UserRating;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {

        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userID, UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieID(), Movie.class);
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
        })
                .collect(Collectors.toList());

        //get all movie ids
        //call movie info service for ratings
        //combine data

    }
}