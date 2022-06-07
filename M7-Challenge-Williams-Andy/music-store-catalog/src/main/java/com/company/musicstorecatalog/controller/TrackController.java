package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.exception.InvalidRequestException;
import com.company.musicstorecatalog.exception.NoRecordFoundException;
import com.company.musicstorecatalog.model.Label;
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

    @RequestMapping(value="/label", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getAllLabels() {
        return serviceLayer.findAllLabels();
    }

    @RequestMapping(value="/label", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Label createLabel(@RequestBody Label label) {
        return serviceLayer.saveLabel(label);
    }

    @RequestMapping(value="/label/{id}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Label getLabelById(@PathVariable int id) {
        Label label = serviceLayer.findLabel(id);
        if (label == null) {
            throw new NoRecordFoundException("Label with id " + id + " does not exist.");
        }
        return label;
    }

    @RequestMapping(value="/label/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabel(@PathVariable int id, @RequestBody Label label) {
        if (label.getId() == 0) {
            label.setId(id);
        }
        if (label.getId() != id) {
            throw new InvalidRequestException("id in request body must match id in path");
        }
        serviceLayer.updateLabel(label);
    }

    @RequestMapping(value="/label/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLabel(@PathVariable int id) {
        serviceLayer.removeLabel(id);
    }


}
