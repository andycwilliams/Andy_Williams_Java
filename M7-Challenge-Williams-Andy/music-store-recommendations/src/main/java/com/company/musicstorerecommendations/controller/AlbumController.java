package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.exception.InvalidRequestException;
import com.company.musicstorerecommendations.exception.NoRecordFoundException;
import com.company.musicstorerecommendations.model.Album;
import com.company.musicstorerecommendations.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAllAlbums() { return albumRepository.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody Album album) { return albumRepository.save(album); }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album getAlbumById(@PathVariable int id) {
        Optional<Album> album = albumRepository.findById(id);
        if (album.isPresent()) {
            return album.get();
        } else {
            throw new NoRecordFoundException("Album with ID " + id + " does not exist.");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@PathVariable int id, @RequestBody Album album) {
        if (album.getAlbumRecommendationId() == null) {
            album.setAlbumRecommendationId(id);
        }
        if (album.getAlbumRecommendationId() != id) {
            throw new InvalidRequestException("ID in request body must match ID in path");
        }
        albumRepository.save(album);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable int id) { albumRepository.deleteById(id); }
}
