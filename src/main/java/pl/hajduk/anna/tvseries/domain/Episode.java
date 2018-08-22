package pl.hajduk.anna.tvseries.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Episode {
    private String title;
    private Genre genre;
    private LocalDateTime premiereDate;
    private Double review;
}
