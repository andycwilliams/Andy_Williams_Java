package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.exception.InvalidRequestException;
import com.company.musicstorecatalog.exception.NoRecordFoundException;
import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value="/artist", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllArtists() {
        return serviceLayer.findAllArtists();
    }

    @RequestMapping(value="/artist", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody Artist artist) {
        return serviceLayer.saveArtist(artist);
    }

    @RequestMapping(value="/artist/{id}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Artist getArtistById(@PathVariable int id) {
        Artist artist = serviceLayer.findArtist(id);
        if (artist == null) {
            throw new NoRecordFoundException("Artist with id " + id + " does not exist.");
        }
        return artist;
    }

    @RequestMapping(value="/artist/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@PathVariable int id, @RequestBody Artist artist) {
        if (artist.getId() == 0) {
            artist.setId(id);
        }
        if (artist.getId() != id) {
            throw new InvalidRequestException("id in request body must match id in path");
        }
        serviceLayer.updateArtist(artist);
    }

    @RequestMapping(value="/artist/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable int id) {
        serviceLayer.removeArtist(id);
    }

}
