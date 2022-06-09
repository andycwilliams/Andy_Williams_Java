package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.exception.InvalidRequestException;
import com.company.musicstorerecommendations.exception.NoRecordFoundException;
import com.company.musicstorerecommendations.repository.ArtistRepository;
import com.company.musicstorerecommendations.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    ArtistRepository artistRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Artist getArtistById(@PathVariable int id) {
        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isPresent()) {
            return artist.get();
        } else {
            throw new NoRecordFoundException("Artist with ID " + id + " does not exist.");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@PathVariable int id, @RequestBody Artist artist) {
        if (artist.getArtistRecommendationId() == null) {
            artist.setArtistRecommendationId(id);
        }
        if (artist.getArtistRecommendationId() != id) {
            throw new InvalidRequestException("ID in request body must match ID in path.");
        }
        artistRepository.save(artist);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable int id) { artistRepository.deleteById(id); }
}
