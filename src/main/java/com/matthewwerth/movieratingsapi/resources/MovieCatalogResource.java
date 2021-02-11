package com.matthewwerth.movieratingsapi.resources;

import com.matthewwerth.movieratingsapi.models.CatalogItem;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class MovieCatalogResource {
    public List<CatalogItem> getCatalog(String userID) {
        return Collections.singletonList(
                new CatalogItem("Titanic", "test", 4)
        );
    }
}

