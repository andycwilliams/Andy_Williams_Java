package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.exception.InvalidRequestException;
import com.company.musicstorerecommendations.exception.NoRecordFoundException;
import com.company.musicstorerecommendations.service.ServiceLayer;
import com.company.musicstorerecommendations.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllArtists() {
        return serviceLayer.findAllArtists();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody Artist artist) {
        return serviceLayer.saveArtist(artist);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Artist getArtistById(@PathVariable int id) {
        Artist artist = serviceLayer.findArtist(id);
        if (artist == null) {
            throw new NoRecordFoundException("Artist with ID " + id + " does not exist.");
        }
        return artist;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@PathVariable int id, @RequestBody Artist artist) {
        if (artist.getArtistId() == 0) {
            artist.setArtistId(id);
        }
        if (artist.getArtistId() != id) {
            throw new InvalidRequestException("ID in request body must match ID in path");
        }
        serviceLayer.updateArtist(artist);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable int id) { serviceLayer.removeArtist(id); }
}
