package task_Strengthening_skills.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler(value = {ClientException.class})
    public ResponseEntity<Object> handlerRequestException(ClientException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handlerRequestException(Exception e) {
        return new ResponseEntity<>(ClientExceptionEnum.BAD_REQUEST.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
