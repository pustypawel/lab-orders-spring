package pl.edu.wszib.labordersspring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.edu.wszib.labordersspring.order.exception.OrderNotFoundException;
import pl.edu.wszib.labordersspring.rest.api.ErrorResponse;

@RestControllerAdvice
public class OrderErrorHandler {
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<?> handleOrderNotFoundException(OrderNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("ORDER_NOT_FOUND",
                        "Order with given id not found. id = " + e.getOrderId()));
    }

}
