package EventCleanJava.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandle {

    @ExceptionHandler(DuplicateEventExceptions.class)
    public ResponseEntity<Map<String, String>> handleDuplicateExceptions(DuplicateEventExceptions exception){

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "Please, insert a valid hashId for your event and try again");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundEventExceptions.class)
    public ResponseEntity<Map<String, String>> handleNotFoundExceptions(NotFoundEventExceptions exception){

        Map<String, String> response = new HashMap<>();
        response.put("Error: ", exception.getMessage());
        response.put("Message: ", "The request event was not found, check the identifier try again");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }












    // Vai mandar um erro caso o Id seja inválido e pedir pro usuário tentar de novo
    // @RestControllerAdvice - Toda vez que a exceção acessar algo no controller
}
