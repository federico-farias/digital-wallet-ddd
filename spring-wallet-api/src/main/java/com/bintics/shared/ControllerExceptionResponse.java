package com.bintics.shared;

import com.bintics.shared.BusinessException;
import com.bintics.shared.NotFoundException;
import com.bintics.context.customer.application.api.schema.ErrorHttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionResponse extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new ErrorHttpResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return ResponseEntity.notFound().build();
    }

}
