package ru.practice.dogouslugi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.practice.dogouslugi.model.Dog;
import ru.practice.dogouslugi.service.DogService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DogControllerTest {
    private MockMvc mockMvc;
    private DogService dogService;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        dogService = mock(DogService.class);
        DogController controller = new DogController(dogService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnCatList() throws Exception {
        doReturn(
            List.of(
                getTestDog()
            )
        ).when(dogService).listDog();

        mockMvc.perform(get("/api/dog/list")
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("$[0].name").value("Tuzya"));

        verify(dogService).listDog();
    }

    @Test
    void shouldAddDog() throws Exception {
      Dog dog = getTestDog();

        mockMvc.perform(post("/api/dog/add")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectMapper.writeValueAsString(dog)))
          .andDo(print())
          .andExpect(status().isOk());

        verify(dogService).addDog(any());
    }

    @Test
    void shouldGetCat() throws Exception {
        doReturn(getTestDog()).when(dogService).getDog(1L);

        mockMvc.perform(get("/api/dog/get?id=1")
            .contentType(MediaType.APPLICATION_JSON))
          .andDo(print())
          .andExpect(status().isOk());

        verify(dogService).getDog(1L);
    }

    @Test
    void shouldDeleteDog() throws Exception {
        doNothing().when(dogService).deleteDog(1L);

        mockMvc.perform(delete("/api/dog/deleteDog?id=1")
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk());

        verify(dogService).deleteDog(any());
    }

    private Dog getTestDog() {
        return Dog.builder()
            .id(1L)
            .age("2")
            .breed("bully")
            .sex("male")
            .name("Tuzya")
            .build();
    }
}
