package com.project.ecommerce.advice;

import com.project.ecommerce.exception.SHIPMENTEMPTYEXCEPTION;
import com.project.ecommerce.exception.WAREHOUSEEMPTYEXCEPTION;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> getinvalidexception(MethodArgumentNotValidException exc){
        Map<String,String> errormap= new HashMap<>();
        exc.getBindingResult().getAllErrors().forEach((error)->{
            errormap.put(((FieldError) error).getField(),error.getDefaultMessage());

        });
        return errormap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WAREHOUSEEMPTYEXCEPTION.class)
    public Map<String ,String> warehouseemptyexception(WAREHOUSEEMPTYEXCEPTION exc){
        Map<String ,String> errormap= new HashMap<>();
        errormap.put("Error Message", exc.getMessage());
        errormap.put("es","1");
        return errormap;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String> noSuchElementException(NoSuchElementException noSuchElementException){
        Map<String ,String> errormap= new HashMap<>();
        errormap.put("Error Message", noSuchElementException.getMessage());
        errormap.put("es","1");

        return errormap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SHIPMENTEMPTYEXCEPTION.class)
    public String shipmentemptyexception(){
        return "no shipment schedule";
    }
}
