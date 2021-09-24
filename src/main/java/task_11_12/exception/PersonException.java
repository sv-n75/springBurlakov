package task_11_12.exception;


public class PersonException extends RuntimeException {

    //  PersonExceptionEnum personExceptionEnum;

//    public PersonException(Throwable cause, PersonExceptionEnum personExceptionEnum) {
//        super(cause);
//        this.personExceptionEnum = personExceptionEnum;
//    }


    public PersonException(String message) {
        super(message);
    }

    public PersonException(String message, Throwable cause) {
        super(message, cause);
    }
}



