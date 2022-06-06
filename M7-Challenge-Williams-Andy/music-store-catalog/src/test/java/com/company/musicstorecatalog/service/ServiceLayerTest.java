package com.company.musicstorecatalog.service;

import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.repository.*;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ServiceLayerTest {

    ServiceLayer service;
    AlbumRepository albumRepository;
    ArtistRepository artistRepository;
    LabelRepository labelRepository;
    TrackRepository trackRepository;

    @Before
    public void setUp() throws Exception {
        setUpAlbumRepositoryMock();
        setUpArtistRepositoryMock();
        setUpLabelRepositoryMock();
        setUpTrackRepositoryMock();

        service = new ServiceLayer(albumRepository, artistRepository, labelRepository, trackRepository);

    }

    // Helper methods
    private void setUpAlbumRepositoryMock() {
        albumRepository = mock(AlbumRepository.class);
        Album album = new Album();
        album.setId(1);
        album.setArtistId(45);
        album.setLabelId(10);
        album.setTitle("Greatest Hits");
        album.setListPrice(new BigDecimal("14.99"));
        album.setReleaseDate(LocalDate.of(1999, 05, 15));

        Album album2 = new Album();
        album2.setArtistId(45);
        album2.setLabelId(10);
        album2.setTitle("Greatest Hits");
        album2.setListPrice(new BigDecimal("14.99"));
        album2.setReleaseDate(LocalDate.of(1999, 05, 15));

        List<Album> aList = new ArrayList<>();
        aList.add(album);

        doReturn(album).when(albumRepository).save(album2);
        doReturn(Optional.of(album)).when(albumRepository).findById(1);
        doReturn(aList).when(albumRepository).findAll();
    }

    private void setUpArtistRepositoryMock() {
        artistRepository = mock(ArtistRepository.class);
        Artist artist = new Artist();
        artist.setId(45);
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");

        Artist artist2 = new Artist();
        artist2.setInstagram("@RockStar");
        artist2.setName("The GOAT");
        artist2.setTwitter("@TheRockStar");

        List aList = new ArrayList();
        aList.add(artist);

        doReturn(artist).when(artistRepository).save(artist2);
        doReturn(Optional.of(artist)).when(artistRepository).findById(45);
        doReturn(aList).when(artistRepository).findAll();
    }

    private void setUpLabelRepositoryMock() {
        labelRepository = mock(LabelRepository.class);
        Label label = new Label();
        label.setId(10);
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        Label label2 = new Label();
        label2.setName("Blue Note");
        label2.setWebsite("www.bluenote.com");

        List lList = new ArrayList<>();
        lList.add(label);

        doReturn(label).when(labelRepository).save(label2);
        doReturn(Optional.of(label)).when(labelRepository).findById(10);
        doReturn(lList).when(labelRepository).findAll();
    }

    private void setUpTrackRepositoryMock() {
        trackRepository = mock(TrackRepository.class);
        Track track = new Track();
        track.setId(1);
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        Track track2 = new Track();
        track.setAlbumId(1);
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");

        List tList = new ArrayList<>();
        tList.add(track);

        doReturn(track).when(trackRepository).save(track2);
        doReturn(Optional.of(track)).when(trackRepository).findById(1);
        doReturn(tList).when(trackRepository).findAll();
        doReturn(tList).when(trackRepository).findAllTracksByAlbumId(1);
    }

    @Test
    public void findAllAlbums() {
        List<AlbumViewModel> fromService = service.findAllAlbums();

        assertEquals(1, fromService.size());
    }

    @Test
    public void shouldSaveArtist() {
        Artist artistToSave = new Artist();
        artistToSave.setInstagram("@RockStar");
        artistToSave.setName("The GOAT");
        artistToSave.setTwitter("@TheRockStar");

        Artist expectedArtist = new Artist();
        expectedArtist.setInstagram("@RockStar");
        expectedArtist.setName("The GOAT");
        expectedArtist.setTwitter("@TheRockStar");
        expectedArtist.setId(45);

        Artist actualResult = service.saveArtist(artistToSave);

        assertEquals(expectedArtist, actualResult);
    }

    @Test
    public void shouldFindAlbumAndBuildViewModelCorrectly() {
        AlbumViewModel whatIExpect = new AlbumViewModel();

        whatIExpect.setListPrice(new BigDecimal("14.99"));
        whatIExpect.setReleaseDate(LocalDate.of(1999, 05, 15));
        whatIExpect.setTitle("Greatest Hits");
        whatIExpect.setId(1);

        Artist artist = new Artist();
        artist.setInstagram("@RockStar");
        artist.setName("The GOAT");
        artist.setTwitter("@TheRockStar");
        artist.setId(45);
        whatIExpect.setArtist(artist);

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");
        label.setId(10);

        whatIExpect.setLabel(label);

        Track track = new Track();
        track.setRunTime(180);
        track.setTitle("Number 1 Hit!");
        track.setAlbumId(1);
        track.setId(1);
        List<Track> tList = new ArrayList<>();
        tList.add(track);

        whatIExpect.setTracks(tList);

        // Act
        AlbumViewModel fromService = service.findAlbum(1);

        // Assert
        assertEquals(whatIExpect, fromService);

    }

    @Test
    public void shouldFindLabel() {
        Label expectedLabel = new Label();
        expectedLabel.setId(10);
        expectedLabel.setName("Blue Note");
        expectedLabel.setWebsite("www.bluenote.com");

        Label actualResult = service.findLabel(10);

        assertEquals(expectedLabel, actualResult);
    }

    @Test
    public void shouldReturnNullIfLabelNotFound() {
        Label actualResult = service.findLabel(54321);

        assertNull(actualResult);
    }

    @Test
    public void shouldSaveLabel() {
        // Arrange
        Label expectedOutput = new Label();
        expectedOutput.setId(10);
        expectedOutput.setName("Blue Note");
        expectedOutput.setWebsite("www.bluenote.com");

        Label label = new Label();
        label.setName("Blue Note");
        label.setWebsite("www.bluenote.com");

        // Act
        Label actualOutput = service.saveLabel(label);

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }
}
