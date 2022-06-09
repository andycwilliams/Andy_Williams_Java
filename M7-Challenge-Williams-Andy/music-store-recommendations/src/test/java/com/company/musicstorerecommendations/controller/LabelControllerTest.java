package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Label;
import com.company.musicstorerecommendations.repository.LabelRepository;
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
@WebMvcTest(LabelController.class)
public class LabelControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    LabelRepository labelRepository;

    private ObjectMapper mapper = new ObjectMapper();

    Label label;
    Label labelOutput;

    Label label2;
    Label label2Output;

    @Before
    public void setup() throws Exception {
        label = new Label(811, 822, false);
        labelOutput = new Label(113, 811, 822, false);

        doReturn(labelOutput).when(labelRepository).save(label);
        doReturn(Optional.of(labelOutput)).when(labelRepository).findById(113);

        label2 = new Label(55, 32, false);
        label2Output = new Label(623,55, 32, false);

        doReturn(label2Output).when(labelRepository).save(label2);
        doReturn(Optional.of(label2Output)).when(labelRepository).findById(623);
    }

    @Test
    public void shouldCreateLabel() throws Exception{
        String inputJson = mapper.writeValueAsString(label);

        mockMvc.perform(post("/label")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetLabelById() throws Exception{
        String inputJson = mapper.writeValueAsString(labelOutput);

        mockMvc.perform(get("/label/113")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllLabels() throws Exception{
        String outputJson = mapper.writeValueAsString(labelOutput);

        mockMvc.perform(get("/label")
                        .content(outputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateLabel() throws Exception{
        String inputJson = mapper.writeValueAsString(label2Output);

        mockMvc.perform(put("/label/623")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/label/623")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(content().json(inputJson));
    }

    @Test
    public void shouldDeleteLabel() throws Exception{
        mockMvc.perform(delete("/label/623")).andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturn404WhenGetLabelByInvalidId() throws Exception{
        mockMvc.perform(get("/label/-1")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void shouldBeUnprocessableEntityWhenUpdateLabelWithNonMatchingIds() throws Exception {
        String inputJson = mapper.writeValueAsString(labelOutput);

        mockMvc.perform(put("/label/-5")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}