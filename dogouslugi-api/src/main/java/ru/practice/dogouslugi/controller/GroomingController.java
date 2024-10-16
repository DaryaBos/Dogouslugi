package ru.practice.dogouslugi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.practice.dogouslugi.model.Grooming;
import ru.practice.dogouslugi.service.GroomingService;

@Controller
@RequestMapping("/api/grooming")
@Tag(name = "GroomingController", description = "Метод для добавления записи на груминг")
public class GroomingController extends BaseController {

    private final GroomingService groomingService;

    public GroomingController(GroomingService groomingService) {
      this.groomingService = groomingService;
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Добавить запись на груминг", tags = {"Собачье АПИ"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")
    })
    public ResponseEntity<Long> addGrooming(@RequestBody Grooming grooming) {
      return wrapper((s) -> groomingService.addGrooming(grooming));
    }
}
