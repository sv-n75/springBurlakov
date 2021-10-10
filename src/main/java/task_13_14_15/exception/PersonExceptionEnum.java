package task_13_14_15.exception;

public enum PersonExceptionEnum {
    PERSON_NOT_FOUND("Person not found. This is not good"),
    BAD_REQUEST("this request is bad!!!!!! WHY?????");

    private String message;

    PersonExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
