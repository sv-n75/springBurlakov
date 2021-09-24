package task_11_12.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(value = {PersonException.class})
    public ResponseEntity<Object>handlerRequestException(PersonException e){
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
 ApiPersonException apiPersonException = new ApiPersonException(e.getMessage(), badRequest);
 return new ResponseEntity<>(apiPersonException, badRequest);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object>handlerRequestException(Exception e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiPersonException apiPersonException = new ApiPersonException(PersonExceptionEnum.BAD_REQUEST.getMessage()
                , badRequest);
        return new ResponseEntity<>(apiPersonException, badRequest);
    }
}
