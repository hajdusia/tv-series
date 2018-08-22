package pl.hajduk.anna.tvseries.services;

import pl.hajduk.anna.tvseries.domain.TVSeries;

import java.util.List;

public interface InfoService {

    List<TVSeries> getAll();
}
