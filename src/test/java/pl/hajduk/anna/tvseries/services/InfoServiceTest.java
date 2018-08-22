package pl.hajduk.anna.tvseries.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.hajduk.anna.tvseries.database.DataProvider;
import pl.hajduk.anna.tvseries.domain.Genre;
import pl.hajduk.anna.tvseries.domain.TVSeries;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InfoServiceTest {

    @Mock
    private DataProvider dataProvider;

    @Before
    public void init() {
    }

    @Test
    public void testGetAll() {
        //given
        when(dataProvider.prepareData()).thenReturn(
                Arrays.asList(
                        TVSeries.builder().name("Game of Thrones").build()
                )
        );
        InfoService infoService = new InfoServiceImpl(dataProvider);

        List<TVSeries> expected = Arrays.asList(
                TVSeries.builder().name("Game of Thrones").build()
        );

        //when
        List<TVSeries> actual = infoService.getAll();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetByName() {
        //given
        when(dataProvider.prepareData()).thenReturn(
                Arrays.asList(
                        TVSeries.builder().name("Game of Thrones").build(),
                        TVSeries.builder().name("Sherlock").build(),
                        TVSeries.builder().name("Gossip girl").build()

                )
        );

        InfoService infoService = new InfoServiceImpl(dataProvider);

        TVSeries expected = TVSeries.builder().name("Sherlock").build();

        //when
        Optional<TVSeries> actual = infoService.getByName("Sherlock");

        //then
        Assert.assertEquals(expected, actual.get());
    }

    @Test
    public void testGetByGenre() {
        //given
        when(dataProvider.prepareData()).thenReturn(
                Arrays.asList(
                        TVSeries.builder().name("Game of Thrones").genre(Genre.CRIME).build(),
                        TVSeries.builder().name("Sherlock").genre(Genre.CRIME).build(),
                        TVSeries.builder().name("Gossip girl").genre(Genre.DRAMA).build()

                )
        );

        InfoService infoService = new InfoServiceImpl(dataProvider);

        List<TVSeries> expected = Arrays.asList(
                TVSeries.builder().name("Game of Thrones").genre(Genre.CRIME).build(),
                TVSeries.builder().name("Sherlock").genre(Genre.CRIME).build()
        );

        //when
        List<TVSeries> actual = infoService.getByGenre(Genre.CRIME);

        //then
        Assert.assertEquals(expected, actual);
    }
}
