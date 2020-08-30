package securitydemo.demo.enums;

public enum ErrorMessageEnum {
    USERNAME_PASSWORD_NULL("Username or Password can not be null"),
    PASSWORD_INCORRECT("Password incorrect"),
    USER_NOT_FOUND("User %s not exist");

    private String message;
    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
