package pl.hajduk.anna.tvseries.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hajduk.anna.tvseries.domain.Genre;
import pl.hajduk.anna.tvseries.domain.TVSeries;
import pl.hajduk.anna.tvseries.services.InfoService;
import pl.hajduk.anna.tvseries.services.ReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"", "/"})
public class Controller {

    private InfoService infoService;

    private ReviewService reviewService;

    @Autowired
    public Controller(InfoService infoService, ReviewService reviewService) {
        this.infoService = infoService;
        this.reviewService = reviewService;
    }

    @RequestMapping({"/index", "/tv-series"})
    public List<TVSeries> getAllTVSeries() {
        return infoService.getAll();
    }

    @RequestMapping("tv-series/name/{name}")
    Optional<TVSeries> getTVSeriesByName(@PathVariable String name) {
        return infoService.getByName(name);
    }

    @RequestMapping("tv-series/genre/{genre}")
    List<TVSeries> getTVSeriesByGenre(@PathVariable Genre genre) {
        return infoService.getByGenre(genre);
    }

    @RequestMapping("tv-series/name/{name}/review")
    Optional<Double> getTVSeriesByGenre(@PathVariable String name) {
        return infoService.getByName(name)
                .map(series -> reviewService.getAverageReview(series));
    }

    @PostMapping("tv-series/name/{name}/review/{review}")
    Double review(@PathVariable String name, @PathVariable Integer review) {
        Optional<TVSeries> tvSeries = infoService.getByName(name);

        if (tvSeries.isPresent()) {
            reviewService.review(tvSeries.get(), review);
            return reviewService.getAverageReview(tvSeries.get());
        }

        return null; //improve
    }
}
