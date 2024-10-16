package ru.practice.dogouslugi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.practice.dogouslugi.model.Banner;
import ru.practice.dogouslugi.service.BannerService;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BannerControllerTest {
    private MockMvc mockMvc;
    private BannerService bannerService;

    @BeforeEach
    void setUp() {
      bannerService = mock(BannerService.class);
      BannerController controller = new BannerController(bannerService);
      mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnBannerList() throws Exception {
        doReturn(
            List.of(
                Banner.builder()
                    .id(1L)
                    .title("Хотите завести щеночка?")
                    .bg("linear-gradient(86deg, #8B4513 0%, #FFFEDD 60%, #8B4513 100%)")
                    .imgUrl("corgi18.png")
                    .text("Услуга «Верный друг» поможет подобрать собачий-приют и щенка")
                    .build()
            )
        ).when(bannerService).listBanner();

        mockMvc.perform(get("/api/banner/list")
                .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("$[0].title").value("Хотите завести щеночка?"));

        verify(bannerService).listBanner();
    }
}
