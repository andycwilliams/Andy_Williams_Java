package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.exception.InvalidRequestException;
import com.company.musicstorerecommendations.exception.NoLabelFoundException;
import com.company.musicstorerecommendations.exception.NoRecordFoundException;
import com.company.musicstorerecommendations.repository.LabelRepository;
import com.company.musicstorerecommendations.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelRepository labelRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getAllLabels() { return labelRepository.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Label createLabel(@RequestBody Label label) {
        return labelRepository.save(label);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Label getLabelById(@PathVariable int id) {
        Optional<Label> label = labelRepository.findById(id);
        if (label.isPresent()) {
            return label.get();
        } else {
            throw new NoRecordFoundException("Label with ID " + id + " does not exist.");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabel(@PathVariable int id, @RequestBody Label label) {
        if (label.getLabelRecommendationId() == null) {
            label.setLabelRecommendationId(id);
        }
        if (label.getLabelRecommendationId() != id) {
            throw new InvalidRequestException("ID in request body must match ID in path.");
        }
        labelRepository.save(label);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabel(@PathVariable int id) {
        labelRepository.deleteById(id);
    }
}
