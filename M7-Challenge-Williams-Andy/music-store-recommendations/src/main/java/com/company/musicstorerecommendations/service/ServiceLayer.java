package com.company.musicstorerecommendations.service;

import com.company.musicstorerecommendations.model.*;
import com.company.musicstorerecommendations.repository.AlbumRepository;
import com.company.musicstorerecommendations.repository.ArtistRepository;
import com.company.musicstorerecommendations.repository.LabelRepository;
import com.company.musicstorerecommendations.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Album saveAlbum(Album album) { return albumRepository.save(album); }

    public Album findAlbum(int id) {
        Optional<Album> album = albumRepository.findById(id);
        return album.isPresent() ? album.get() : null;
    }

    public List<Album> findAllAlbums() { return albumRepository.findAll(); }

    public void updateAlbum(Album album) { albumRepository.save(album); }

    public void removeAlbum(int id) { albumRepository.deleteById(id); }

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
