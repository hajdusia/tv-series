package pl.hajduk.anna.tvseries.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hajduk.anna.tvseries.database.DataProvider;
import pl.hajduk.anna.tvseries.domain.Genre;
import pl.hajduk.anna.tvseries.domain.TVSeries;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InfoServiceImpl implements InfoService {
    private final List<TVSeries> tvSeries;

    @Autowired
    public InfoServiceImpl(DataProvider dataProvider) {
        tvSeries = dataProvider.prepareData();
    }

    @Override
    public List<TVSeries> getAll() {
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
