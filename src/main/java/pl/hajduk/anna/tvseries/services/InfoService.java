package pl.hajduk.anna.tvseries.services;

import pl.hajduk.anna.tvseries.domain.Genre;
import pl.hajduk.anna.tvseries.domain.TVSeries;

import java.util.List;
import java.util.Optional;

public interface InfoService {
    List<TVSeries> getAll();

    Optional<TVSeries> getByName(String name);

    List<TVSeries> getByGenre(Genre genre);
}
