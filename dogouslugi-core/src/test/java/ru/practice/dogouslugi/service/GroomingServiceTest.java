package ru.practice.dogouslugi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.practice.dogouslugi.dao.GroomingRepository;
import ru.practice.dogouslugi.model.Grooming;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroomingServiceTest {
    private GroomingRepository groomingRepository;
    private GroomingService groomingService;


  @BeforeEach
    void setUp() {
        groomingRepository = mock(GroomingRepository.class);
        groomingService = new GroomingService(groomingRepository);
    }

  @Test
  void shouldAddGroomingSuccessfully() {
      Grooming grooming = new Grooming(
        1L,
        "Dog1",
        "1234567890",
        "email@example.com",
        "Groomer1",
        "2023-07-18",
        "10:00 AM"
      );

      when(groomingRepository.save(grooming)).thenReturn(grooming);

      Long groomingId = groomingService.addGrooming(grooming);

      assertEquals(1L, groomingId);
      verify(groomingRepository).save(grooming);
  }

  @Test
  void shouldHandleExceptionWhileAddingGrooming() {
      Grooming grooming = new Grooming(
        1L,
        "Dog1",
        "1234567890",
        "email@example.com",
        "Groomer1",
        "2023-07-18",
        "10:00 AM"
      );

      when(groomingRepository.save(grooming)).thenThrow(new RuntimeException("Database error"));

      Long groomingId = groomingService.addGrooming(grooming);

      assertNull(groomingId);
      verify(groomingRepository).save(grooming);
  }
}
