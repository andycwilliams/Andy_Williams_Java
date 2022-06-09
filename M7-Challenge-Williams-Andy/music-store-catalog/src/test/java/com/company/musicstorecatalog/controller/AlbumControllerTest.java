package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.model.Label;
import com.company.musicstorecatalog.model.Track;
import com.company.musicstorecatalog.service.ServiceLayer;
import com.company.musicstorecatalog.viewmodel.AlbumViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {
    @MockBean
    ServiceLayer serviceLayer;

    private AlbumViewModel inputAlbumViewModel;
    private AlbumViewModel outputAlbumViewModel;
    private String inputAlbumViewModelString;
    private String outputAlbumViewModelString;
    private List<AlbumViewModel> allAlbumViewModels;
    private String allAlbumViewModelsString;
    private int albumId = 18;
    private int nonExistentAlbumId = 601;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        Artist inputArtist = new Artist(25, "Singer Zhang", "@watchSZ", "@opinionSZ");
        Label inputLabel = new Label(9, "Goodonyas", "www.goodonyasmusic.net");
        List<Track> inputTracks = Arrays.asList(new Track(10, "Songsville", 200));
        inputAlbumViewModel = new AlbumViewModel("My Album", inputArtist, LocalDate.of(2022, 5, 18), inputLabel, new BigDecimal("10.95"), inputTracks);

        List<Track> outputTracks = Arrays.asList(new Track(831, "Songsville", 200));
        outputAlbumViewModel = new AlbumViewModel(albumId, "My Album", inputArtist, LocalDate.of(2022, 5, 18), inputLabel, new BigDecimal("10.95"), outputTracks);
        inputAlbumViewModelString = mapper.writeValueAsString(inputAlbumViewModel);
        outputAlbumViewModelString = mapper.writeValueAsString(outputAlbumViewModel);
        allAlbumViewModels = Arrays.asList(outputAlbumViewModel);
        allAlbumViewModelsString = mapper.writeValueAsString(allAlbumViewModels);

        when(serviceLayer.saveAlbum(inputAlbumViewModel)).thenReturn(outputAlbumViewModel);
        when(serviceLayer.findAllAlbums()).thenReturn(allAlbumViewModels);
        when(serviceLayer.findAlbum(albumId)).thenReturn(outputAlbumViewModel);
    }

    @Test
    public void shouldCreateAlbum() throws Exception {
        mockMvc.perform(post("/album")
                        .content(inputAlbumViewModelString)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputAlbumViewModelString));
    }

    @Test
    public void shouldGetAllAlbums() throws Exception {
        mockMvc.perform(get("/album"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(allAlbumViewModelsString));
    }

    @Test
    public void shouldGetAlbumById() throws Exception {
        mockMvc.perform(get("/album/" + albumId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputAlbumViewModelString));
    }

    @Test
    public void shouldUpdateAlbum() throws Exception {
        mockMvc.perform(put("/album/" + albumId)
                        .content(outputAlbumViewModelString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteArtist() throws Exception {
        mockMvc.perform(delete("/album/" + albumId))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReport404WhenFindAlbumByInvalidId() throws Exception {
        mockMvc.perform(get("/album/" + nonExistentAlbumId))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldBeUnprocessableEntityWhenPutRequestContainsNonMatchingIds() throws Exception {
        mockMvc.perform(put("/album/" + nonExistentAlbumId)
                        .content(outputAlbumViewModelString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}