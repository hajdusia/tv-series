package pl.hajduk.anna.tvseries.services;

import pl.hajduk.anna.tvseries.domain.TVSeries;

public interface ReviewService {
    void review(TVSeries series, Integer review);

    Double getAverageReview(TVSeries tvSeries);
}
