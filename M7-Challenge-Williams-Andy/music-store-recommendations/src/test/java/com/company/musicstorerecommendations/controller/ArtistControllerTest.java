package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Artist;
import com.company.musicstorerecommendations.repository.ArtistRepository;
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

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArtistController.class)
public class ArtistControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    ArtistRepository artistRepository;

    private ObjectMapper mapper = new ObjectMapper();

    Artist artist;
    Artist artistOutput;

    Artist artist2;
    Artist artist2Output;

    @Before
    public void setup() throws Exception {
        artist = new Artist(44, 12, false);
        artistOutput = new Artist(454,44, 12, false);

        doReturn(artistOutput).when(artistRepository).save(artist);
        doReturn(Optional.of(artistOutput)).when(artistRepository).findById(454);

        artist2 = new Artist(1234, 777, true);
        artist2Output = new Artist(343,1234, 777, true);

        doReturn(artist2Output).when(artistRepository).save(artist2);
        doReturn(Optional.of(artist2Output)).when(artistRepository).findById(343);
    }

    @Test
    public void shouldCreateArtist() throws Exception{
        String inputJson = mapper.writeValueAsString(artist);

        mockMvc.perform(post("/artist")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetArtistById() throws Exception{
        String inputJson = mapper.writeValueAsString(artistOutput);

        mockMvc.perform(get("/artist/454")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllArtists() throws Exception{
        String outputJson = mapper.writeValueAsString(artistOutput);

        mockMvc.perform(get("/artist")
                        .content(outputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateArtist() throws Exception{
        String inputJson = mapper.writeValueAsString(artist2Output);

        mockMvc.perform(put("/artist/343")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/artist/343")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(content().json(inputJson));
    }

    @Test
    public void shouldDeleteArtist() throws Exception{
        mockMvc.perform(delete("/artist/343")).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn404WhenGetArtistByInvalidId() throws Exception{
        mockMvc.perform(get("/artist/-1")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void shouldBeUnprocessableEntityWhenUpdateArtistByNonMatchingIds() throws Exception {
        String inputJson = mapper.writeValueAsString(artistOutput);

        mockMvc.perform(put("/artist/-5")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}