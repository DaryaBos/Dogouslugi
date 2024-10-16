package ru.practice.dogouslugi.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import ru.practice.dogouslugi.exception.ServiceException;
import ru.practice.dogouslugi.util.FunctionSE;

public class BaseController {

    protected <T> ResponseEntity<T> wrapper(FunctionSE<T> f) {
        try {
            return new ResponseEntity<>(f.apply(null), HttpStatusCode.valueOf(200));
        } catch (ServiceException e) {
          return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }
}
