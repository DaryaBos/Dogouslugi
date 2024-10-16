package ru.practice.dogouslugi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.practice.dogouslugi.model.Dog;
import ru.practice.dogouslugi.service.DogService;

import java.util.List;

@RestController
@RequestMapping("/api/dog")
@Tag(name = "DogController", description = "Методы для работы с АПИ пользователей")
public class DogController extends BaseController {
    private final DogService dogService;

  public DogController(DogService dogService) {
    this.dogService = dogService;
  }

    @GetMapping(value = "/list", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Получить список собачек", tags = {"Собачье АПИ"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public List<Dog> listCat() {
      return dogService.listDog();
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Добавить собачку", tags = {"Собачье АПИ"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<Long> addDog(@RequestBody Dog dog) {
        return wrapper((s) -> dogService.addDog(dog));
    }

    @GetMapping(value = "/get", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Получить собачки по идентификатору", tags = {"Собачье АПИ"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<Dog> getDog(@Parameter(name = "id", required = true) @RequestParam Long id) {
        return wrapper((s) -> dogService.getDog(id));
    }

    @DeleteMapping(value = "deleteDog", produces = "application/json")
    @Operation(summary = "Удалить собачки", tags = {"Собачье АПИ"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public void deleteDog(@RequestParam Long id) {
        dogService.deleteDog(id);
    }
}
