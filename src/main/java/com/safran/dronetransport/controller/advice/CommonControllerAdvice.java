package com.safran.dronetransport.controller.advice;

import com.safran.dronetransport.exception.RequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> onRuntimeException(RuntimeException e){
        ErrorResponse errorResponse = ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.toString()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RequestException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> onRequestException(RequestException e){
        ErrorResponse errorResponse = ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.toString()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
