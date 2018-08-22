package pl.hajduk.anna.tvseries.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class Episode {
    private String title;
    private LocalDate premiereDate;
}
