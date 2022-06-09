package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Album;
import com.company.musicstorerecommendations.repository.AlbumRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class AlbumControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    AlbumRepository albumRepository;

    private ObjectMapper mapper = new ObjectMapper();

    Album album;
    Album albumOutput;

    Album album2;
    Album album2Output;

    @Before
    public void setup() throws Exception {
        album = new Album(17, 7, true);
        albumOutput = new Album(17, 7, true);
        albumOutput.setAlbumId(177);

        doReturn(albumOutput).when(albumRepository).save(album);
        doReturn(Optional.of(albumOutput)).when(albumRepository).findById(177);

        album2 = new Album(55, 32, false);
        album2Output = new Album(55, 32, false);
        album2Output.setAlbumId(900);

        doReturn(album2Output).when(albumRepository).save(album2);
        doReturn(Optional.of(album2Output)).when(albumRepository).findById(900);
    }

    @Test
    public void shouldCreateAlbum() throws Exception{
        String inputJson = mapper.writeValueAsString(album);
        String outputJson = mapper.writeValueAsString(albumOutput);

        mockMvc.perform(post("/album")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetAlbumById() throws Exception{
        String inputJson = mapper.writeValueAsString(albumOutput);

        mockMvc.perform(get("/album/177")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllAlbums() throws Exception{
        String outputJson = mapper.writeValueAsString(albumOutput);

        mockMvc.perform(get("/album")
                        .content(outputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateAlbum() throws Exception{
        String inputJson = mapper.writeValueAsString(albumOutput);

        mockMvc.perform(put("/album/177")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/album/177")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(content().json(inputJson));
    }

    @Test
    public void shouldDeleteAlbum() throws Exception{
        mockMvc.perform(delete("/album/177")).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn404WhenGetAlbumByInvalidId() throws Exception{
        mockMvc.perform(get("/album/-1")).andDo(print()).andExpect(status().isNotFound());
    }
}