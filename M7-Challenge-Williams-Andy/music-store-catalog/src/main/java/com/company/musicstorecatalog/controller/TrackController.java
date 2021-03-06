package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.exception.InvalidRequestException;
import com.company.musicstorecatalog.exception.NoRecordFoundException;
import com.company.musicstorecatalog.model.Track;
import com.company.musicstorecatalog.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {
    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getAllTracks() { return serviceLayer.findAllTracks(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Track createTrack(@RequestBody Track track) { return serviceLayer.saveTrack(track); }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Track getTrackById(@PathVariable int id) {
        Track track = serviceLayer.findTrack(id);
        if (track == null) {
            throw new NoRecordFoundException("Track with ID " + id + " does not exist.");
        }
        return track;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrack(@PathVariable int id, @RequestBody Track track) {
        if (track.getId() == null) {
            track.setId(id);
        }
        if (track.getId() != id) {
            throw new InvalidRequestException("ID in request body must match ID in path");
        }
        serviceLayer.updateTrack(track);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(@PathVariable int id) { serviceLayer.removeTrack(id); }
}
