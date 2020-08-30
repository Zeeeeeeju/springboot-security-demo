package securitydemo.demo.exception;

import org.springframework.security.core.AuthenticationException;

public class UsernamePasswordNotNullException extends AuthenticationException {

    public UsernamePasswordNotNullException(String msg) {
        super(msg);
    }

}
