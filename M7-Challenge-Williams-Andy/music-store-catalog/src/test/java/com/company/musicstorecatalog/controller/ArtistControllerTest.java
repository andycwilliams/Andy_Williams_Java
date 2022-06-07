package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Artist;
import com.company.musicstorecatalog.service.ServiceLayer;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArtistController.class)
public class ArtistControllerTest {
    @MockBean
    ServiceLayer serviceLayer;

    private Artist inputArtist;
    private Artist outputArtist;
    private String inputArtistString;
    private String outputArtistString;

    private List<Artist> allArtists;
    private String allArtistsString;
    private int artistId = 55;
    private int nonExistentArtistId = 999;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        inputArtist = new Artist("Jackson 5", "@jackson5Insta", "@jackson5Twitter");
        outputArtist = new Artist(artistId, "Jackson 5", "@jackson5Insta", "@jackson5Twitter");
        inputArtistString = mapper.writeValueAsString(inputArtist);
        outputArtistString = mapper.writeValueAsString(outputArtist);
        allArtists = Arrays.asList(outputArtist);
        allArtistsString = mapper.writeValueAsString(allArtists);

        when(serviceLayer.saveArtist(inputArtist)).thenReturn(outputArtist);
        when(serviceLayer.findAllArtists()).thenReturn(allArtists);
        when(serviceLayer.findArtist(artistId)).thenReturn(outputArtist);


    }

    @Test
    public void shouldCreateArtist() throws Exception {
        mockMvc.perform(post("/artist")
                .content(inputArtistString)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputArtistString));
    }

    @Test
    public void shouldGetAllArtists() throws Exception {
        mockMvc.perform(get("/artist"))
                .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().json(allArtistsString));
    }

    @Test
    public void shouldGetArtistById() throws Exception {
        mockMvc.perform(get("/artist/" + artistId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputArtistString));
    }


    @Test
    public void shouldReport404WhenFindArtistByInvalidId() throws Exception {
        mockMvc.perform(get("/artist/" + nonExistentArtistId))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    @Test
    public void shouldUpdateArtist() throws Exception {
        mockMvc.perform(put("/artist/" + artistId)
                .content(outputArtistString)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldBeUnprocessableEntityWhenPutRequestContainsNonMatchingIds() throws Exception {
        mockMvc.perform(put("/artist/" + nonExistentArtistId)
                        .content(outputArtistString)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldDeleteArtist() throws Exception {
        mockMvc.perform(delete("/artist/" + artistId))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}