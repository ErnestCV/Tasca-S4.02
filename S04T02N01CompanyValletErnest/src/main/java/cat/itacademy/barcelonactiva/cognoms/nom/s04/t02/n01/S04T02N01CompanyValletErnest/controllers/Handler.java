package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.exceptions.FruitaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class Handler {

    @ExceptionHandler({FruitaNotFoundException.class})
    public ResponseEntity<Object> handleFruitaNotFoundException(FruitaNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).toList();
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    //TODO: posar timestamp, etc.
}
