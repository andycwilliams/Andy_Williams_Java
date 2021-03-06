package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.exception.InvalidRequestException;
import com.company.musicstorecatalog.exception.NoRecordFoundException;
import com.company.musicstorecatalog.service.ServiceLayer;
import com.company.musicstorecatalog.viewmodel.AlbumViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private ServiceLayer serviceLayer;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumViewModel> getAllAlbums() {
        return serviceLayer.findAllAlbums();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbumViewModel createAlbum(@RequestBody AlbumViewModel albumViewModel) {
        return serviceLayer.saveAlbum(albumViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumViewModel getAlbumById(@PathVariable int id) {
        AlbumViewModel avm = serviceLayer.findAlbum(id);
        if (avm == null) {
            throw new NoRecordFoundException("Album ID " + id + " not found.");
        }
        return serviceLayer.findAlbum(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@PathVariable int id, @RequestBody AlbumViewModel avm) {
        if (avm.getId() == null) {
            avm.setId(id);
        }
        if (avm.getId() != id) {
            throw new InvalidRequestException("ID in request body must match ID in path");
        }
        serviceLayer.updateAlbum(avm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable int id) { serviceLayer.removeAlbum(id); }
}
