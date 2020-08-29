package securitydemo.demo.handler;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityAuthenticationFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if(e instanceof InternalAuthenticationServiceException){
            response.setStatus(404);
            response.getWriter().write(e.getMessage());
            return ;
        }
        response.setStatus(403);
        response.getWriter().write(e.getMessage());
    }
}
