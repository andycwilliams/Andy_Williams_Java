package com.company.musicstorecatalog.service;

import com.company.reccoll.model.Album;
import com.company.reccoll.model.Artist;
import com.company.reccoll.model.Label;
import com.company.reccoll.model.Track;
import com.company.reccoll.repository.AlbumRepository;
import com.company.reccoll.repository.ArtistRepository;
import com.company.reccoll.repository.LabelRepository;
import com.company.reccoll.repository.TrackRepository;
import com.company.reccoll.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {

    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private LabelRepository labelRepository;
    private TrackRepository trackRepository;

    @Autowired
    public ServiceLayer(AlbumRepository albumRepository, ArtistRepository artistRepository,
                        LabelRepository labelRepository, TrackRepository trackRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.labelRepository = labelRepository;
        this.trackRepository = trackRepository;
    }

    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel) {

        // Persist Album
        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());
        a = albumRepository.save(a);
        viewModel.setId(a.getId());

        // Add Album Id to Tracks and Persist Tracks
        List<Track> tracks = viewModel.getTracks();

        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    trackRepository.save(t);
                });

        tracks = trackRepository.findAllTracksByAlbumId(viewModel.getId());
        viewModel.setTracks(tracks);

        return viewModel;
    }

    public AlbumViewModel findAlbum(int id) {

        // Get the album object first
        Optional<Album> album = albumRepository.findById(id);

        return album.isPresent() ? buildAlbumViewModel(album.get()) : null;
    }

    private AlbumViewModel buildAlbumViewModel(Album album) {

        // Get the associated artist
        Optional<Artist> artist = artistRepository.findById(album.getArtistId());

        // Get the associated label
        Optional<Label> label = labelRepository.findById(album.getLabelId());

        // Get the tracks associated with the album
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(album.getId());

        // Assemble the AlbumViewModel
        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getId());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getReleaseDate());
        avm.setListPrice(album.getListPrice());
        avm.setArtist(artist.get());
        avm.setLabel(label.get());
        avm.setTracks(trackList);

        // Return the AlbumViewModel
        return avm;
    }

    public List<AlbumViewModel> findAllAlbums() {

        List<Album> albumList = albumRepository.findAll();

        List<AlbumViewModel> avmList = new ArrayList<>();

        for (Album album : albumList) {
            AlbumViewModel avm = buildAlbumViewModel(album);
            avmList.add(avm);
        }

        return avmList;
    }

    @Transactional
    public void updateAlbum(AlbumViewModel viewModel) {

        // Update the album information
        Album album = new Album();
        album.setId(viewModel.getId());
        album.setArtistId(viewModel.getArtist().getId());
        album.setLabelId(viewModel.getLabel().getId());
        album.setListPrice(viewModel.getListPrice());
        album.setReleaseDate(viewModel.getReleaseDate());

        albumRepository.save(album);

        // We don't know if any track have been removed so delete all associated tracks
        // and then associate the tracks in the viewModel with the album
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(album.getId());
        trackList.stream()
                .forEach(track -> trackRepository.deleteById(track.getId()));

        List<Track> tracks = viewModel.getTracks();
        tracks.stream()
                .forEach(t ->
                {
                    t.setAlbumId(viewModel.getId());
                    t = trackRepository.save(t);
                });
    }

    @Transactional
    public void removeAlbum(int id) {

        // Remove all associated tracks first
        List<Track> trackList = trackRepository.findAllTracksByAlbumId(id);

        trackList.stream()
                .forEach(track -> trackRepository.deleteById(track.getId()));

        // Remove album
        albumRepository.deleteById(id);

    }

    //
    // Artist API
    //

    public Artist saveArtist(Artist artist) {

        return artistRepository.save(artist);
    }

    public Artist findArtist(int id) {

        Optional<Artist> artist = artistRepository.findById(id);
        return artist.isPresent() ? artist.get() : null;
    }

    public List<Artist> findAllArtists() {

        return artistRepository.findAll();
    }

    public void updateArtist(Artist artist) {

        artistRepository.save(artist);
    }

    public void removeArtist(int id) {

        artistRepository.deleteById(id);
    }

    //
    // Label API
    //

    public Label saveLabel(Label label) {

        return labelRepository.save(label);
    }

    public Label findLabel(int id) {

        Optional<Label> label = labelRepository.findById(id);
        return label.isPresent() ? label.get() : null;
    }

    public List<Label> findAllLabels() {

        return labelRepository.findAll();
    }

    public void updateLabel(Label label) {

        labelRepository.save(label);
    }

    public void removeLabel(int id) {

        labelRepository.deleteById(id);
    }
}
