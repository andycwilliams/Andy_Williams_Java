package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.exception.InvalidRequestException;
import com.company.musicstorerecommendations.exception.NoLabelFoundException;
import com.company.musicstorerecommendations.service.ServiceLayer;
import com.company.musicstorerecommendations.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getAllLabels() {
        return serviceLayer.findAllLabels();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Label createLabel(@RequestBody Label label) {
        return serviceLayer.saveLabel(label);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Label getLabelById(@PathVariable int id) {
        Label label = serviceLayer.findLabel(id);
        if (label == null) {
            throw new NoLabelFoundException("Label with ID " + id + " does not exist.");
        }
        return label;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabel(@PathVariable int id, @RequestBody Label label) {
        if (label.getLabelId() == 0) {
            label.getLabelId(id);
        }
        if (label.getLabelId() != id) {
            throw new InvalidRequestException("ID in request body must match ID in path.");
        }
        serviceLayer.updateLabel(label);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabel(@PathVariable int id) {
        serviceLayer.removeLabel(id);
    }
}
