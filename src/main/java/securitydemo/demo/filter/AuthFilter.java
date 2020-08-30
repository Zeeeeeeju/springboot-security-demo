package securitydemo.demo.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import securitydemo.demo.enums.ErrorMessageEnum;
import securitydemo.demo.exception.UsernamePasswordNotNullException;
import securitydemo.demo.handler.SecurityAuthenticationFailHandler;
import sun.misc.BASE64Encoder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends OncePerRequestFilter {

    private static final String LOGIN_URL = "/login";
    private AuthenticationFailureHandler handler = new SecurityAuthenticationFailHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(LOGIN_URL.equals(request.getRequestURI()) && (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))){
            handler.onAuthenticationFailure(request,response,new UsernamePasswordNotNullException(ErrorMessageEnum.USERNAME_PASSWORD_NULL.getMessage()));
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
