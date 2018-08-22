package pl.hajduk.anna.tvseries.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pl.hajduk.anna.tvseries.domain.TVSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {

    @Test
    public void testReview() {
        //given
        TVSeries tvSeries = TVSeries.builder().name("Game of Thrones").reviews(new ArrayList<>(Arrays.asList(7, 9))).build();
        ReviewService reviewService = new ReviewServiceImpl();
        List<Integer> expected = Arrays.asList(7, 9, 8);

        //when
        reviewService.review(tvSeries, 8);

        //then
        Assert.assertEquals(expected, tvSeries.getReviews());
    }

    @Test
    public void testGetAverageReview() {
        //given
        TVSeries tvSeries = TVSeries.builder().name("Game of Thrones").reviews(new ArrayList<>(Arrays.asList(6, 4))).build();
        ReviewService reviewService = new ReviewServiceImpl();
        Double expected = 5d;

        //when
        Double actual = reviewService.getAverageReview(tvSeries);

        //then
        Assert.assertEquals(expected, actual);
    }
}
