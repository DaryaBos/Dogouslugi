package ru.practice.dogouslugi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.practice.dogouslugi.exception.ServiceException;
import ru.practice.dogouslugi.model.Category;
import ru.practice.dogouslugi.model.DogoServiceEntity;
import ru.practice.dogouslugi.service.DogoService;

import java.util.List;

import static ru.practice.dogouslugi.request.RequestId.asRequestId;

@RestController
@RequestMapping("/api")
@Tag(name = "ProductServiceController", description = "Методы для работы с АПИ собачьихуслуг")
public class ProductServiceController extends BaseController {
    private final DogoService dogoService;

    public ProductServiceController(DogoService dogoService) {
      this.dogoService = dogoService;
    }

    @GetMapping(value = "test/hello", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Поздороваться с сервисом", tags = {"Тестовые запросы"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<String> hello() {
        return wrapper((s) -> "hello test!!");
    }

    @GetMapping(value = "test/exception", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Поймать ошибку", tags = {"Тестовые запросы"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<String> testException() {
        return wrapper((s) -> {
            throw new ServiceException("test exception!");
        });
    }

    @GetMapping(value = "/service/list", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Список сервисов собачьихуслуг", tags = {"Собачьимиуслугами"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<List<DogoServiceEntity>> listService() {
        return wrapper((s) -> dogoService.listServices());
    }

    @GetMapping(value = "/service/byId/{id}", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Получить сервис собачьихуслуг по идентификатору", tags = {"Собачьимиуслугами"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<DogoServiceEntity> getServiceById(
      @Parameter(name = "requestId", required = true) @PathVariable Integer id) {
        return wrapper((s) -> dogoService.getServiceById(asRequestId(id)));
    }

    @GetMapping(value = "/service/categories", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Получить список категорий", tags = {"Собачьимиуслугами"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<List<Category>> listCategories() {
        return wrapper((s) -> dogoService.listCategories());
    }
}
