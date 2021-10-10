package task_13_14_15.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(value = {PersonException.class})
    public ResponseEntity<Object>handlerRequestException(PersonException e){
 return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object>handlerRequestException(Exception e){
        return new ResponseEntity<>(PersonExceptionEnum.BAD_REQUEST.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
