package pl.hajduk.anna.tvseries.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class TVSeries {
    private String name;
    private Genre genre;
    private Map<Integer, List<Episode>> seasonToEpisodes;
    private List<Integer> reviews;
}
