package task_Strengthening_skills.exception;

public enum ClientExceptionEnum {
    CLIENT_NOT_FOUND("Client not found. This is not good"),
    BAD_REQUEST("this request is bad!!!!!! WHY?????"),
    ORDER_NOT_FOUND("Order not found");

    private String message;

    ClientExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
