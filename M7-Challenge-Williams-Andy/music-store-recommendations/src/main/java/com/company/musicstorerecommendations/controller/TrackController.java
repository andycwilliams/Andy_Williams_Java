package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.exception.InvalidRequestException;
import com.company.musicstorerecommendations.exception.NoRecordFoundException;
import com.company.musicstorerecommendations.repository.TrackRepository;
import com.company.musicstorerecommendations.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/track")
public class TrackController {
    @Autowired
    TrackRepository trackRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getAllTracks() { return trackRepository.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Track createTrack(@RequestBody Track track) {
        return trackRepository.save(track);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Track getTrackById(@PathVariable int id) {
        Optional<Track> track = trackRepository.findById(id);
        if (track.isPresent()) {
            return track.get();
        } else {
            throw new NoRecordFoundException("Track with ID " + id + " does not exist.");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrack(@PathVariable int id, @RequestBody Track track) {
        if (track.getTrackRecommendationId() == null) {
            track.setTrackRecommendationId(id);
        }
        if (track.getTrackRecommendationId() != id) {
            throw new InvalidRequestException("ID in request body must match ID in path.");
        }
        trackRepository.save(track);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(@PathVariable int id) { trackRepository.deleteById(id); }
}
