package br.com.priscila.zedelivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public StandardError resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        return StandardError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error("Resource not found")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DatabaseException.class)
    public StandardError database(DatabaseException e, HttpServletRequest request) {
        return StandardError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Database error")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public StandardError httpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request) {
        return StandardError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("JSON parse error: Points of LinearRing do not form a closed linestring")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
    }

}