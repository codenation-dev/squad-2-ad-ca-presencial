package br.com.codenation.centralerrosapi.controller.exception;

import br.com.codenation.centralerrosapi.service.exception.AuthorizationException;
import br.com.codenation.centralerrosapi.service.exception.ResourceExistsException;
import br.com.codenation.centralerrosapi.service.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFound(ResourceNotFoundException e, HttpServletRequest r) {

        ErrorMessage err = new ErrorMessage(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), e.getMessage(), r.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<ErrorMessage> resourceExists(ResourceExistsException e, HttpServletRequest r) {

        ErrorMessage err = new ErrorMessage(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage(), r.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> illegalArgument(IllegalArgumentException e, HttpServletRequest r){

        ErrorMessage err = new ErrorMessage(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage(), r.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<ErrorMessage> authorization(AuthorizationException e, HttpServletRequest req) {

        ErrorMessage err = new ErrorMessage(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase(), e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }

}
