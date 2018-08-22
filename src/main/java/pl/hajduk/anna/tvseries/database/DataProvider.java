package pl.hajduk.anna.tvseries.database;

import org.springframework.stereotype.Component;
import pl.hajduk.anna.tvseries.domain.Episode;
import pl.hajduk.anna.tvseries.domain.Genre;
import pl.hajduk.anna.tvseries.domain.TVSeries;

import java.time.LocalDate;
import java.util.*;

@Component
public class DataProvider {

    public List<TVSeries> prepareData() {
        List<TVSeries> tvSeries = new ArrayList<>();

        Episode aaa = Episode.builder().title("aaa").premiereDate(LocalDate.of(2012, 12, 12)).build();
        Episode bbb = Episode.builder().title("bbb").premiereDate(LocalDate.of(2012, 12, 12)).build();
        Episode ccc = Episode.builder().title("ccc").premiereDate(LocalDate.of(2012, 12, 12)).build();
        Episode ddd = Episode.builder().title("ddd").premiereDate(LocalDate.of(2012, 12, 12)).build();
        Map<Integer, List<Episode>> seasonToEpisodes = new HashMap<>();

        seasonToEpisodes.put(1, Arrays.asList(aaa, bbb));
        seasonToEpisodes.put(2, Arrays.asList(ccc, ddd));

        List<Integer> reviews = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 8, 9)));

        TVSeries breakingBad = TVSeries.builder()
                .name("Breaking bad")
                .genre(Genre.THRILLER)
                .seasonToEpisodes(seasonToEpisodes)
                .reviews(reviews)
                .build();

        TVSeries gameOfThrones = TVSeries.builder()
                .name("Game of thrones")
                .genre(Genre.CRIME)
                .seasonToEpisodes(seasonToEpisodes)
                .reviews(reviews)
                .build();

        tvSeries.add(breakingBad);
        tvSeries.add(gameOfThrones);
        return tvSeries;
    }
}