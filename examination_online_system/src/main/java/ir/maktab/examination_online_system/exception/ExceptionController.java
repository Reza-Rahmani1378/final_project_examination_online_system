package ir.maktab.examination_online_system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(value = BadInputRunTimeException.class)
    public ResponseEntity<String> handle(BadInputRunTimeException e) {

        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.BAD_REQUEST
        );

    }

    @ExceptionHandler(value = AccessDeniedRunTimeException.class)
    public ResponseEntity<String> handle(AccessDeniedRunTimeException e) {

        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.FORBIDDEN
        );

    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> getTransactionException(MethodArgumentNotValidException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.BAD_REQUEST);

        //Get all errors
        List<ErrorDTO> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ErrorDTO implements Serializable {
        private String field;
        private String message;
    }

}
