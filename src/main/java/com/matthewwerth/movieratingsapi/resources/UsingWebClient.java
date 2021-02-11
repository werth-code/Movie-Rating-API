//package com.matthewwerth.movieratingsapi.resources;
//
//import com.matthewwerth.movieratingsapi.models.CatalogItem;
//import com.matthewwerth.movieratingsapi.models.Movie;
//import com.matthewwerth.movieratingsapi.models.Rating;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/catalog")
//public class UsingWebClient {
//
//        @Autowired
//        private RestTemplate restTemplate;
//
//        @Autowired
//        private WebClient.Builder builder;
//
//        @RequestMapping("/{userID}")
//        public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {
//
//            List<Rating> ratings = Arrays.asList(     // this is hardcoded example of api response
//                    new Rating("123", 5),
//                    new Rating("234", 4),
//                    new Rating("345", 3)
//            );
//
//            return ratings.stream().map(rating -> { //async way to handle this request.
//               Movie movie = builder.build()
//                        .get()     //type of request - could be post, put etc.
//                        .uri("http://localhost:8081/movies/" + rating.getMovieID()) // what we need to access
//                        .retrieve()  // fetch it...
//                        .bodyToMono(Movie.class)   // convert it to an instance of Movie.class (mono is like a promise in js)
//                        .block();  // block execution until this Movie is returned..
//
//                return new CatalogItem(movie.getName(), "Description", rating.getRating());
//            })
//                    .collect(Collectors.toList());
//
//        }
//    }
//
//
