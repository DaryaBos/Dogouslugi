package ru.practice.dogouslugi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.practice.dogouslugi.model.Requisition;
import ru.practice.dogouslugi.service.RequisitionService;

import java.util.List;

@RestController
@RequestMapping("/api/requisition")
@Tag(name = "RequisitionController", description = "Методы для работы с заявлениями собачьихуслуг")
public class RequisitionController extends BaseController {
    private final RequisitionService requisitionService;

    public RequisitionController(RequisitionService requisitionService) {
      this.requisitionService = requisitionService;
    }

    @GetMapping(value = "/list", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Список реквизитов заявления", tags = {"Собачьимиуслугами","Заявления"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<List<Requisition>> listRequisition() {
        return wrapper((s) -> requisitionService.listRequisition());
    }


    @PostMapping(value = "/create", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Создать заявление", tags = {"Собачьимиуслугами","Заявления"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<Integer> createRequisition(@Parameter(name = "request", required = true)
                                                         @RequestBody Requisition requisition) {
        return wrapper((s) -> requisitionService.createRequisition(requisition));
    }


    @PostMapping(value = "/update", produces = "application/json")
    @ResponseBody
    @Operation(summary = "Обновить заявление", tags = {"Собачьимиуслугами","Заявления"}, responses = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "500", description = "Внутренняя ошибка")}
    )
    public ResponseEntity<Boolean> updateRequisition(@Parameter(name = "request",required = true)
                                                   @RequestBody Requisition requisition) {
        return wrapper((s) -> requisitionService.updateRequisition(requisition));
    }
}
