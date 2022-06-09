package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Track;
import com.company.musicstorerecommendations.repository.TrackRepository;
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
@WebMvcTest(TrackController.class)
public class TrackControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    TrackRepository trackRepository;

    private ObjectMapper mapper = new ObjectMapper();

    Track track;
    Track trackOutput;

    Track track2;
    Track track2Output;

    @Before
    public void setup() throws Exception {
        track = new Track(9, 9, true);
        trackOutput = new Track(8, 9, 9, true);

        doReturn(trackOutput).when(trackRepository).save(track);
        doReturn(Optional.of(trackOutput)).when(trackRepository).findById(8);

        track2 = new Track(2, 2, true);
        track2Output = new Track(7,2, 2, true);

        doReturn(track2Output).when(trackRepository).save(track2);
        doReturn(Optional.of(track2Output)).when(trackRepository).findById(7);
    }

    @Test
    public void shouldCreateTrack() throws Exception{
        String inputJson = mapper.writeValueAsString(track);

        mockMvc.perform(post("/track")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetTrackById() throws Exception{
        String inputJson = mapper.writeValueAsString(trackOutput);

        mockMvc.perform(get("/track/8")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllTracks() throws Exception{
        String outputJson = mapper.writeValueAsString(trackOutput);

        mockMvc.perform(get("/track")
                        .content(outputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateTrack() throws Exception{
        String inputJson = mapper.writeValueAsString(track2Output);

        mockMvc.perform(put("/track/7")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/track/7")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(content().json(inputJson));
    }

    @Test
    public void shouldDeleteTrack() throws Exception{
        mockMvc.perform(delete("/track/7")).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn404WhenGetTrackByInvalidId() throws Exception{
        mockMvc.perform(get("/track/-1")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void shouldBeUnprocessableEntityWhenUpdateTrackWithNonMatchingIds() throws Exception {
        String inputJson = mapper.writeValueAsString(trackOutput);

        mockMvc.perform(put("/track/-5")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}