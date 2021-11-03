package task_16.exception;

public enum PersonExceptionEnum {
    PERSON_NOT_FOUND("Person not found. This is not good"),
    BAD_REQUEST("this request is bad!!!!!! WHY?????"),
    DEPARTMENT_NOT_FOUND("Department not found");

    private String message;

    PersonExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
