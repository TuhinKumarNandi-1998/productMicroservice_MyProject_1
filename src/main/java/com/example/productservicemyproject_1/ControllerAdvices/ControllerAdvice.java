package com.example.productservicemyproject_1.ControllerAdvices;

import com.example.productservicemyproject_1.Exceptions.ProductNotFoundException;
import com.example.productservicemyproject_1.dtos.ProductNotFoundExceptionHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionHandlerDTO> handleProductNotFoundException(ProductNotFoundException exception) {
        ProductNotFoundExceptionHandlerDTO productNotFoundExceptionHandlerDTO = new ProductNotFoundExceptionHandlerDTO();
        productNotFoundExceptionHandlerDTO.setMessage(exception.getMessage());

        return new ResponseEntity<>(productNotFoundExceptionHandlerDTO, HttpStatus.NOT_FOUND);
    }
}
