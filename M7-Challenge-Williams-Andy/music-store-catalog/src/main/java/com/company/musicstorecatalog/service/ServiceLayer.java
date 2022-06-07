package com.company.musicstorecatalog.service;

import com.company.musicstorecatalog.exception.NoRecordFoundException;
import com.company.musicstorecatalog.repository.AlbumRepository;
import com.company.musicstorecatalog.repository.ArtistRepository;
import com.company.musicstorecatalog.repository.LabelRepository;
import com.company.musicstorecatalog.repository.TrackRepository;
import com.company.musicstorecatalog.model.Album;
import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.model.Track;
import com.company.musicstorecatalog.viewmodel.AlbumViewModel;
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

    // ALBUM
    @Transactional
    public AlbumViewModel saveAlbum(AlbumViewModel viewModel) {

        Album a = new Album();
        a.setTitle(viewModel.getTitle());
        a.setReleaseDate(viewModel.getReleaseDate());
        a.setListPrice(viewModel.getListPrice());
        a.setLabelId(viewModel.getLabel().getId());
        a.setArtistId(viewModel.getArtist().getId());
        a = albumRepository.save(a);
        viewModel.setId(a.getId());

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

        Optional<Album> album = albumRepository.findById(id);

        return album.isPresent() ? buildAlbumViewModel(album.get()) : null;
    }

    private AlbumViewModel buildAlbumViewModel(Album album) {

        Optional<Artist> artist = artistRepository.findById(album.getArtistId());

        Optional<Label> label = labelRepository.findById(album.getLabelId());

        List<Track> trackList = trackRepository.findAllTracksByAlbumId(album.getId());

        AlbumViewModel avm = new AlbumViewModel();
        avm.setId(album.getId());
        avm.setTitle(album.getTitle());
        avm.setReleaseDate(album.getReleaseDate());
        avm.setListPrice(album.getListPrice());
        avm.setArtist(artist.get());
        avm.setLabel(label.get());
        avm.setTracks(trackList);

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

        Album album = new Album();
        album.setId(viewModel.getId());
        album.setArtistId(viewModel.getArtist().getId());
        album.setLabelId(viewModel.getLabel().getId());
        album.setListPrice(viewModel.getListPrice());
        album.setReleaseDate(viewModel.getReleaseDate());

        albumRepository.save(album);

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

        List<Track> trackList = trackRepository.findAllTracksByAlbumId(id);

        trackList.stream()
                .forEach(track -> trackRepository.deleteById(track.getId()));

        albumRepository.deleteById(id);
    }

    // ARTIST
    public Artist saveArtist(Artist artist) { return artistRepository.save(artist); }

    public Artist findArtist(int id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.isPresent() ? artist.get() : null;
    }

    public List<Artist> findAllArtists() { return artistRepository.findAll(); }

    public void updateArtist(Artist artist) { artistRepository.save(artist); }

    public void removeArtist(int id) { artistRepository.deleteById(id); }

    // LABEL
    public Label saveLabel(Label label) { return labelRepository.save(label); }

    public Label findLabel(int id) {
        Optional<Label> label = labelRepository.findById(id);
        return label.isPresent() ? label.get() : null;
    }

    public List<Label> findAllLabels() { return labelRepository.findAll(); }

    public void updateLabel(Label label) { labelRepository.save(label); }

    public void removeLabel(int id) { labelRepository.deleteById(id); }


    // TRACK
    public Track saveTrack(Track track) { return trackRepository.save(track); }

    public Track findTrack(int id) {
        Optional<Track> track = trackRepository.findById(id);
        return track.isPresent() ? track.get() : null;
    }

    public List<Track> findAllTracks() { return trackRepository.findAll(); }

    public void updateTrack(Track track) { trackRepository.save(track); }

    public void removeTrack(int id) { trackRepository.deleteById(id); }
}
