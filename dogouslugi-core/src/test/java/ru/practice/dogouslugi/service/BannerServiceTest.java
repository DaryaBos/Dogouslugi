package ru.practice.dogouslugi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.practice.dogouslugi.dao.BannerRepository;
import ru.practice.dogouslugi.model.Banner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BannerServiceTest {
    private BannerRepository bannerRepository;
    private BannerService bannerService;

    @BeforeEach
    void setUp() {
        bannerRepository = mock(BannerRepository.class);
        bannerService = new BannerService(bannerRepository);
    }

    @Test
    void shouldReturnBannerList() {
        when(bannerRepository.findAll()).thenReturn(
            () -> getBannerList().iterator()
        );

        bannerService.listBanner();

        verify(bannerRepository).findAll();
    }

    private List<Banner> getBannerList() {
        return List.of(
            Banner.builder()
              .id(1L)
              .title("Хотите завести щеночка?")
              .bg("linear-gradient(86deg, #8B4513 0%, #FFFEDD 60%, #8B4513 100%)")
              .imgUrl("corgi18.png")
              .text("Услуга «Верный друг» поможет подобрать собачий-приют и щенка")
              .build()
        );
    }
}
