package com.company.musicstorecatalog.controller;

import com.company.musicstorecatalog.model.Track;
import com.company.musicstorecatalog.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(AlbumController.class)
public class TrackControllerTest {

    @MockBean
    ServiceLayer serviceLayer;
    private Track inputTrack;
    private Track outputTrack;
    private String inputTrackString;
    private String outputTrackString;

    private List<Track> allTracks;
    private String allTracksString;
    private int trackId = 44;
    private int nonExistentTrackId = 101;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        inputTrack = new Track(4, "Title of the Song", 60);
        outputTrack = new Track(trackId, 4, "Title of the Song", 60);
        inputTrackString = mapper.writeValueAsString(inputTrack);
        outputTrackString = mapper.writeValueAsString(outputTrack);
        allTracks = Arrays.asList(outputTrack);
        allTracksString = mapper.writeValueAsString(allTracks);

        when(serviceLayer.saveTrack(inputTrack)).thenReturn(outputTrack);
        when(serviceLayer.findAllTracks()).thenReturn(allTracks);
        when(serviceLayer.findTrack(trackId)).thenReturn(outputTrack);
    }
}
