package pl.hajduk.anna.tvseries.services;

import org.springframework.stereotype.Service;
import pl.hajduk.anna.tvseries.domain.TVSeries;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Override
    public void review(TVSeries tvSeries, Integer review) {
        tvSeries.getReviews().add(review);
    }

    @Override
    public Double getAverageReview(TVSeries tvSeries) {
        return tvSeries.getReviews()
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }
}