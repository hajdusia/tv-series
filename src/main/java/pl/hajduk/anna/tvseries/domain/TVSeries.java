package pl.hajduk.anna.tvseries.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TVSeries {

    private String name;
    private Map<Integer, List<Episode>> seasonToEpisodes;


}
