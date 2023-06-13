package com.project.ecommerce.advice;

import com.project.ecommerce.exception.SHIPMENTEMPTYEXCEPTION;
import com.project.ecommerce.exception.WAREHOUSEEMPTYEXCEPTION;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(WAREHOUSEEMPTYEXCEPTION.class)
    public String warehouseemptyexception(WAREHOUSEEMPTYEXCEPTION exc){
        return "Warehouse is empty";
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoSuchElementException.class)
    public String warehousenotfound(NoSuchElementException exc){
    return "warehouse not found";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SHIPMENTEMPTYEXCEPTION.class)
    public String shipmentemptyexception(){
        return "no shipment schedule";
    }
}
