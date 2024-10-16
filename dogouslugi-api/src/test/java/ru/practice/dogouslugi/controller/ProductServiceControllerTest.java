package ru.practice.dogouslugi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.practice.dogouslugi.model.Category;
import ru.practice.dogouslugi.model.DogoServiceEntity;
import ru.practice.dogouslugi.service.DogoService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductServiceControllerTest {
    private MockMvc mockMvc;
    private DogoService dogoService;


    @BeforeEach
    void setUp() {
        dogoService = mock(DogoService.class);
        ProductServiceController controller = new ProductServiceController(dogoService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnServiceList() throws Exception {
        doReturn(
            List.of(
                getTestEntity()
            )
        ).when(dogoService).listServices();

        mockMvc.perform(get("/api/service/list")
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].icon").value("corgi.png"))
            .andExpect(jsonPath("$[0].title").value("Верный друг"));

        verify(dogoService).listServices();
    }

    @Test
    void shouldReturnService() throws Exception {
        doReturn(getTestEntity()).when(dogoService).getServiceById(any());

        mockMvc.perform(get("/api/service/byId/1")
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.icon").value("corgi.png"))
            .andExpect(jsonPath("$.title").value("Верный друг"));

        verify(dogoService).getServiceById(any());
    }

    @Test
    void shouldReturnCategoryList() throws Exception {
        doReturn(
            List.of(
                getTestCategory()
            )
        ).when(dogoService).listCategories();

        mockMvc.perform(get("/api/service/categories")
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].name").value("family"));

        verify(dogoService).listCategories();
    }

    private DogoServiceEntity getTestEntity() {
        return DogoServiceEntity.builder()
            .title("Верный друг")
            .categories(
                List.of(
                    getTestCategory()
                )
            )
            .icon("corgi.png")
            .build();
    }

    private Category getTestCategory() {
        Category category = new Category();
        category.setId(1);
        category.setName("family");
        return category;
    }
}
