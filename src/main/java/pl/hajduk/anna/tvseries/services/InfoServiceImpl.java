package pl.hajduk.anna.tvseries.services;

import org.springframework.stereotype.Service;
import pl.hajduk.anna.tvseries.domain.Episode;
import pl.hajduk.anna.tvseries.domain.Genre;
import pl.hajduk.anna.tvseries.domain.TVSeries;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public List<TVSeries> getAll() {
        ArrayList<TVSeries> tvSeries = new ArrayList<>();

        Episode aaa = Episode.builder().title("aaa").premiereDate(LocalDate.of(2012, 12, 12)).build();
        Episode bbb = Episode.builder().title("bbb").premiereDate(LocalDate.of(2012, 12, 12)).build();
        Episode ccc = Episode.builder().title("ccc").premiereDate(LocalDate.of(2012, 12, 12)).build();
        Episode ddd = Episode.builder().title("ddd").premiereDate(LocalDate.of(2012, 12, 12)).build();
        HashMap<Integer, List<Episode>> seasonToEpisodes = new HashMap<>();

        seasonToEpisodes.put(1, Arrays.asList(aaa, bbb));
        seasonToEpisodes.put(2, Arrays.asList(ccc, ddd));

        TVSeries breakingBad = TVSeries.builder()
                .name("Breaking bad")
                .genre(Genre.THRILLER)
                .seasonToEpisodes(seasonToEpisodes)
                .reviews(Arrays.asList(8, 9, 4))
                .build();

        tvSeries.add(breakingBad);

        return tvSeries;
    }

    @Override
    public Optional<TVSeries> getByName(String name) {
        return getAll().stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<TVSeries> getByGenre(Genre genre) {
        return getAll().stream()
                .filter(s -> s.getGenre().equals(genre))
                .collect(Collectors.toList());
    }
}
