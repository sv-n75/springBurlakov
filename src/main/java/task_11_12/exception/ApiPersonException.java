package task_11_12.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class ApiPersonException {

    private final String message;
    private final HttpStatus httpStatus;

    public ApiPersonException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
