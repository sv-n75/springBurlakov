package task_11_12.exception;

public enum PersonExceptionEnum {
    PERSON_NOT_FOUND("Person not found. This is not good"),
    BAD_REQUEST("this request is bad!!!!!! WHY?????");

    String message;

    PersonExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
